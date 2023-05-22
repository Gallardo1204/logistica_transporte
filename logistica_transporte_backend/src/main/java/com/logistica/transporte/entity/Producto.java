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
@Entity(name = "lbd_productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pro_id", nullable = false)
    private Long id;

    @Column(name = "pro_nombre", nullable = false)
    private String nombre;

    @Column(name = "pro_precio", nullable = false)
    private String precio;
}
