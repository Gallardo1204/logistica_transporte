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
@Entity(name = "lbd_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id", nullable = false)
    private BigInteger id;

    @Column(name = "cli_nombre", nullable = false)
    private String nombre;

    @Column(name = "cli_num_identificacion", nullable = false)
    private String numIndetificacion;

    @Column(name = "cli_direccion ", nullable = false)
    private String direccion;

    @Column(name = "cli_telefono", nullable = false)
    private String telefono;

    @Column(name = "cli_correo ")
    private String correo;

}
