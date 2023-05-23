package com.logistica.transporte.dto;

import com.logistica.transporte.config.validators.PasswordValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "{usuario.nombre.notblank}")
    private String nombre;

    @Email(message = "{usuario.correo.notvalid}")
    @NotBlank(message = "{usuario.correo.notblank}")
    private String correo;

    @NotBlank(message = "{usuario.password.notblank}")
    @PasswordValidation(message = "{usuario.password.patternmatch}")
    private String password;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private boolean isActive;

    private String token;

}
