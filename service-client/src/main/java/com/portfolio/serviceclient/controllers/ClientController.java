package com.portfolio.serviceclient.controllers;

import com.portfolio.serviceclient.dao.AddressDAO;
import com.portfolio.serviceclient.dao.ClientDAO;
import com.portfolio.serviceclient.exceptions.ResourceNotFoundException;
import com.portfolio.serviceclient.models.Address;
import com.portfolio.serviceclient.models.Client;
import com.portfolio.serviceclient.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Operation(summary = "List all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Present client list",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDAO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No clients were found",
                    content = @Content)})
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ClientDAO>> findAll() {
        var clients = clientService.findAll();
        if (ObjectUtils.isEmpty(clients)) {
            throw new RuntimeException("Clients Not Found");
        }
        return ResponseEntity.ok(clients.stream().map(client -> convertToClientDAO(client)).collect(Collectors.toList()));
    }

    @Operation(summary = "List client by ID ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Present a specific client data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDAO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No clients were found",
                    content = @Content)})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientDAO> findById(@PathVariable("id") @Min(1) Integer id) {
        Client result = clientService.findById(BigInteger.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("User with ID :" + id + " Not Found!"));

        return ResponseEntity.ok(convertToClientDAO(result));
    }

    public ClientDAO convertToClientDAO(Client client) {

        ClientDAO result = ClientDAO.builder()
                .id(client.getId())
                .email(client.getEmail())
                .completeName(client.getCompleteName())
                .abrevName(client.getAbrevName())
                .birthday(client.getBirthday())
                .cpfCnpj(client.getCpfCnpj()).build();

        if (ObjectUtils.isNotEmpty(client.getAdressList())) {
            result.setAddressList(client.getAdressList().stream().map(address -> convertToAddressDAO(address)).collect(Collectors.toList()));
        }

        return result;
    }

    private AddressDAO convertToAddressDAO(Address address) {

        return AddressDAO.builder()
                .id(address.getId())
                .zipCode(address.getZipCode())
                .streetAddress(address.getStreetAddress())
                .streetNumber(address.getStreetNumber())
                .complement(address.getComplement())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .build();
    }
}
