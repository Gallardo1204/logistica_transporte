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
@Entity(name = "lbd_puertos_maritimos")
public class PuertoMaritimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pm_id", nullable = false)
    private Long id;

    @Column(name = "pm_nombre", nullable = false)
    private String nombre;

    @Column(name = "pm_direccion", nullable = false)
    private String direccion;
}
