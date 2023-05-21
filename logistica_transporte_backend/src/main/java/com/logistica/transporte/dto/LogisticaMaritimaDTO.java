package com.logistica.transporte.dto;

import java.time.LocalDateTime;

public class LogisticaMaritimaDTO {

    private Long id;
    private Long idCliente;
    private Long idProducto;
    private int cantidadProducto;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaEntrega;
    private Long idPuerto;
    private String precioNormal;
    private String precioDescuento;
    private String numeroFlota;
    private String numeroGuia;

}
