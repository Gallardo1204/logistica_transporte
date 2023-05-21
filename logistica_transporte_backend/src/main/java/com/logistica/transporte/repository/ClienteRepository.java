package com.logistica.transporte.repository;

import com.logistica.transporte.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNumIndetificacion(String numIdentificacion);

}
