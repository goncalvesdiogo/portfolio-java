package com.portfolio.serviceclient.util;

import com.portfolio.serviceclient.models.Client;

import java.math.BigInteger;

public class TestFactory {

    public static class ClientFactory{
        public static Client create(){
            return Client.builder()
                    .id(BigInteger.valueOf(1))
                    .completeName("Test of a client 1")
                    .email("Email")
                    .abrevName("Abrev Name")
                    .build();
        }
    }
}
