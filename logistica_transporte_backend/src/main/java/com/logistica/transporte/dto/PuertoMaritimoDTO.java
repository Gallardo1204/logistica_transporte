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
public class PuertoMaritimoDTO {

    private Long id;

    @NotBlank(message = "{puerto.nombre.notBlank}")
    private String nombre;

    @NotBlank(message = "{puerto.direccion.notBlank}")
    private String direccion;

}
