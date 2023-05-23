package com.logistica.transporte.controller;

import com.logistica.transporte.dto.RespuestaGenericaDTO;
import com.logistica.transporte.dto.UsuarioDTO;
import com.logistica.transporte.dto.security.AuthenticationRequest;
import com.logistica.transporte.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/registrar")
    public ResponseEntity<RespuestaGenericaDTO> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioCreado = this.authenticationService.registrarUsuario(usuarioDTO);
        return ResponseEntity.created(URI.create("/api/usuario/" + usuarioCreado.getId())).body(RespuestaGenericaDTO.builder()
                .data(usuarioCreado)
                .mensaje("Se ha creado el usuario exitosamente")
                .build());
    }


    @PostMapping("/login")
    public ResponseEntity<RespuestaGenericaDTO> authentication(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(authenticationService.login(authenticationRequest))
                .mensaje("Inicio de sesión exitoso")
                .build());
    }
}
