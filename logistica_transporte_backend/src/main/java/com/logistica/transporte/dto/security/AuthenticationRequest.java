package com.logistica.transporte.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @Email(message = "{login.correo.notblank}")
    @NotBlank(message = "{usuario.correo.notblank}")
    private String correo;

    @NotBlank(message = "{login.password.notblank}")
    private String password;
}
