package com.logistica.transporte.repository;

import com.logistica.transporte.entity.LogisticaTerrestre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface LogisticaTerrestreRepository extends JpaRepository<LogisticaTerrestre, BigInteger> {
}
