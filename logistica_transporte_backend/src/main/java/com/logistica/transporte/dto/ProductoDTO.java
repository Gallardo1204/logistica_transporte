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
public class ProductoDTO {

    private Long id;

    @NotBlank(message = "{producto.nombre.notBlank}")
    private String nombre;

    @NotBlank(message = "{producto.precio.notBlank}")
    private String precio;

}
