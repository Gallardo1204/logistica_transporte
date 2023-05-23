package com.logistica.transporte.service.security;

import com.logistica.transporte.dto.UsuarioDTO;
import com.logistica.transporte.dto.security.AuthenticationRequest;

public interface AuthenticationService {
    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO login(AuthenticationRequest request);
}
