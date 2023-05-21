package com.logistica.transporte.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class LogisticaTerrestreDTO {

    private BigInteger id;
    private BigInteger idCliente;
    private BigInteger idProducto;
    private int cantidadProducto;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaEntrega;
    private BigInteger idBodega;
    private String precioNormal;
    private String precioDescuento;
    private String placaVehiculo;
    private String numeroGuia;

}
