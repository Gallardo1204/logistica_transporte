package com.logistica.transporte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "lbd_logistica_maritima")
public class LogisticaMaritima {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lm_id", nullable = false)
    private Long id;

    @Column(name = "lm_id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "lm_id_producto", nullable = false)
    private Long idProducto;

    @Column(name = "lm_cant_producto", nullable = false)
    private int cantidadProducto;

    @Column(name = "lm_fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "lm_fecha_entrega", nullable = false)
    private LocalDateTime fechaEntrega;

    @Column(name = "lm_id_puerto", nullable = false)
    private Long idPuerto;

    @Column(name = "lm_precio_normal", nullable = false)
    private String precioNormal;

    @Column(name = "lm_precio_descuento")
    private String precioDescuento;

    @Column(name = "lm_numero_flota", nullable = false)
    private String numeroFlota;

    @Column(name = "lm_numero_guia", nullable = false)
    private String numeroGuia;

}
