package com.portfolio.serviceclient.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ClientDAO {

    private BigInteger id;
    private String email;
    private String completeName;
    private String abrevName;
    private LocalDate birthday;
    private String cpfCnpj;
    private List<AddressDAO> addressList;

}
