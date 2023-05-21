package com.logistica.transporte.repository;

import com.logistica.transporte.entity.PuertoMaritimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PuertoMaritimoRepository extends JpaRepository<PuertoMaritimo, BigInteger> {
}
