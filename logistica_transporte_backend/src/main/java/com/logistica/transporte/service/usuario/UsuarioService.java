package com.logistica.transporte.service.usuario;

import com.logistica.transporte.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO findById(String id);

}
