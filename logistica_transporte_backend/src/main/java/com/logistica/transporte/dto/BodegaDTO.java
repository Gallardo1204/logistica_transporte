package com.logistica.transporte.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BodegaDTO {

    private Long id;

    @NotBlank(message = "{bodega.nombre.notBlank}")
    private String nombre;

    @NotBlank(message = "{bodega.direccion.notBlank}")
    private String direccion;

}
