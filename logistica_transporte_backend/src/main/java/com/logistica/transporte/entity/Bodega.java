package com.logistica.transporte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "lbd_bodegas")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bod_id", nullable = false)
    private Long id;

    @Column(name = "bod_nombre", nullable = false)
    private String nombre;

    @Column(name = "bod_direccion", nullable = false)
    private String direccion;
}
