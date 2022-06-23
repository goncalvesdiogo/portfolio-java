package com.portfolio.serviceclient.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AddressDAO {
    private Long id;
    private String zipCode;
    private String streetAddress;
    private String streetNumber;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
}
