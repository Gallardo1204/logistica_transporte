package com.logistica.transporte.repository;

import com.logistica.transporte.entity.LogisticaMaritima;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface LogisticaMaritimaRepository extends JpaRepository<LogisticaMaritima, BigInteger> {
}
