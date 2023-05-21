package com.logistica.transporte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "lbd_bodegas")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bod_id", nullable = false)
    private BigInteger id;

    @Column(name = "bod_nombre ", nullable = false)
    private String nombre;

    @Column(name = "bod_direccion", nullable = false)
    private String direccion;
}
