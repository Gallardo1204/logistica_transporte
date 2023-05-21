package com.logistica.transporte.dto;

import java.time.LocalDateTime;

public class LogisticaTerrestreDTO {

    private Long id;
    private Long idCliente;
    private Long idProducto;
    private int cantidadProducto;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaEntrega;
    private Long idBodega;
    private String precioNormal;
    private String precioDescuento;
    private String placaVehiculo;
    private String numeroGuia;

}
