package com.logistica.transporte.repository;

import com.logistica.transporte.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProductoRepository extends JpaRepository<Producto, BigInteger> {
}
