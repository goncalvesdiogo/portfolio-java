package com.portfolio.serviceclient.controllers;

import com.portfolio.serviceclient.models.Client;
import com.portfolio.serviceclient.services.ClientService;
import com.portfolio.serviceclient.util.TestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService service;


    @Test
    @DisplayName("Verify that client list is returned sucessfully")
    void verify_if_client_list_is_returned_successfully() throws Exception{

        Client client = TestFactory.ClientFactory.create();
        when(service.findAll()).thenReturn(Arrays.asList(client));
        this.mockMvc.perform(get("/clients/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verify that an error occur when no data is found")
    void verify_that_an_error_occur_when_no_data_is_found() throws Exception{
        when(service.findAll()).thenReturn(null);
        Assertions.assertThrows(NestedServletException.class, ()->this.mockMvc.perform(get("/clients/")));
    }


    @Test
    void convertToClientDAO() {
    }
}