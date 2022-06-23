package com.portfolio.serviceclient.services;

import com.portfolio.serviceclient.models.Client;
import com.portfolio.serviceclient.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(BigInteger id) {
        return clientRepository.findById(id);
    }
}
