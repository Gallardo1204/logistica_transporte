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
public class LogisticaMaritimaDTO {

    private Long id;

    @NotNull(message = "{logistica.maritima.idcliente.notBlank}")
    private Long idCliente;

    @NotNull(message = "{logistica.maritima.idproducto.notBlank}")
    private Long idProducto;

    @NotNull(message = "{logistica.maritima.cantidad.notBlank}")
    private int cantidadProducto;

    @NotNull(message = "{logistica.maritima.fecharegistro.notBlank}")
    private LocalDateTime fechaRegistro;

    @NotNull(message = "{logistica.maritima.fechaentrega.notBlank}")
    private LocalDateTime fechaEntrega;

    @NotNull(message = "{logistica.maritima.idpuerto.notBlank}")
    private Long idPuerto;

    @NotBlank(message = "{logistica.maritima.precio.notBlank}")
    private String precioNormal;

    private String precioDescuento;

    @NotBlank(message = "{logistica.maritima.numeroflota.notBlank}")
    private String numeroFlota;

    @NotBlank(message = "{logistica.maritima.numeroguia.notBlank}")
    private String numeroGuia;

}
