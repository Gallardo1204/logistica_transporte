package com.logistica.transporte.repository;

import com.logistica.transporte.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ClienteRepository extends JpaRepository<Cliente, BigInteger> {
}
