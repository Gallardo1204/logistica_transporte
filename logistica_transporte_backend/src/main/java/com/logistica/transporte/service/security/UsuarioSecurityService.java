package com.logistica.transporte.service.security;

import com.logistica.transporte.entity.Usuario;

public interface UsuarioSecurityService {

    /**
     * El siguiente metodo solo se debe utilizar para fines de seguridad/autenticación
     *
     * @param id
     * @return
     */
    Usuario findByCorreoForSecurity(String correo);

    Usuario updateLastLogin(Usuario usuario);

}
