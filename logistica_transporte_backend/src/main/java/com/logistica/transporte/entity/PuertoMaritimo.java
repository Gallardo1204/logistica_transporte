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
@Entity(name = "lbd_puertos_maritimos")
public class PuertoMaritimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pm_id", nullable = false)
    private BigInteger id;

    @Column(name = "pm_nombre", nullable = false)
    private String nombre;

    @Column(name = "pm_direccion", nullable = false)
    private String direccion;
}
