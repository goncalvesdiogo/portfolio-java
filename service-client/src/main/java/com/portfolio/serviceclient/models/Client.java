package com.portfolio.serviceclient.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "client")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "complete_name", nullable = false)
    private String completeName;

    @Column(name = "abrev_name", nullable = false)
    private String abrevName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    private String cpfCnpj;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Address> adressList;

}
