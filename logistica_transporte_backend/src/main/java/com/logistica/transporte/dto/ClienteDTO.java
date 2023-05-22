package com.logistica.transporte.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "{cliente.nombre.notBlank}")
    private String nombre;

    @NotBlank(message = "{cliente.identificacion.notBlank}")
    private String numIndetificacion;

    @NotBlank(message = "{cliente.direccion.notBlank}")
    private String direccion;

    @NotBlank(message = "{cliente.telefono.notBlank}")
    private String telefono;

    @Email(message = "{cliente.correo.notvalid}")
    @NotBlank(message = "{cliente.correo.notBlank}")
    private String correo;

}
