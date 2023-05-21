package com.logistica.transporte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "lbd_logistica_terrestre")
public class LogisticaTerrestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lt_id", nullable = false)
    private BigInteger id;

    @Column(name = "lt_id_cliente", nullable = false)
    private BigInteger idCliente;

    @Column(name = "lt_id_producto", nullable = false)
    private BigInteger idProducto;

    @Column(name = "lt_cant_producto", nullable = false)
    private int cantidadProducto;

    @Column(name = "lt_fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "lt_fecha_entrega", nullable = false)
    private LocalDateTime fechaEntrega;

    @Column(name = "lt_id_bodega", nullable = false)
    private BigInteger idBodega;

    @Column(name = "lt_precio_normal", nullable = false)
    private String precioNormal;

    @Column(name = "lt_precio_descuento")
    private String precioDescuento;

    @Column(name = "lt_placa_vehiculo", nullable = false)
    private String placaVehiculo;

    @Column(name = "lt_numero_guia", nullable = false)
    private String numeroGuia;
}
