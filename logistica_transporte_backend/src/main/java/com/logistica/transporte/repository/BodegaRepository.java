package com.logistica.transporte.repository;

import com.logistica.transporte.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BodegaRepository extends JpaRepository<Bodega, BigInteger> {
}
