package com.logistica.transporte.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ClienteDTO {

    private BigInteger id;
    private String nombre;
    private String numIndetificacion;
    private String direccion;
    private String telefono;
    private String correo;

}
