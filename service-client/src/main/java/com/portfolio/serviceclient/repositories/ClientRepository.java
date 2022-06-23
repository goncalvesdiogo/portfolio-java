package com.portfolio.serviceclient.repositories;

import com.portfolio.serviceclient.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, BigInteger>{
    Optional<Client> findByEmail(String email);
}
