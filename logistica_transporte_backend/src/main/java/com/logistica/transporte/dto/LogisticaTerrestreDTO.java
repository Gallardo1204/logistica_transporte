package com.logistica.transporte.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogisticaTerrestreDTO {

    private Long id;

    @NotNull(message = "{logistica.terrestre.idcliente.notBlank}")
    private Long idCliente;

    @NotNull(message = "{logistica.terrestre.idproducto.notBlank}")
    private Long idProducto;

    @NotNull(message = "{logistica.terrestre.cantidad.notBlank}")
    private int cantidadProducto;

    @NotNull(message = "{logistica.terrestre.fecharegistro.notBlank}")
    private LocalDateTime fechaRegistro;

    @NotNull(message = "{logistica.terrestre.fechaentrega.notBlank}")
    private LocalDateTime fechaEntrega;

    @NotNull(message = "{logistica.terrestre.idbodega.notBlank}")
    private Long idBodega;

    @NotBlank(message = "{logistica.terrestre.precio.notBlank}")
    private String precioNormal;

    private String precioDescuento;

    @NotBlank(message = "{logistica.terrestre.placavehiculo.notBlank}")
    private String placaVehiculo;

    @NotBlank(message = "{logistica.terrestre.numeroguia.notBlank}")
    private String numeroGuia;

}
