package com.logistica.transporte.service.security;

import com.logistica.transporte.entity.Usuario;
import com.logistica.transporte.exception.ServiceException;
import com.logistica.transporte.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UsuarioSecurityServiceImpl implements UsuarioSecurityService {

    private final MessageSource messageSource;

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByCorreoForSecurity(String correo) {
        return this.usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new ServiceException(this.messageSource.getMessage("usuario.correo.nonexisting", null, Locale.getDefault())
                        .replace("#correo", correo)));
    }

    @Override
    public Usuario updateLastLogin(Usuario usuario) {
        usuario.setLastLogin(new Date(System.currentTimeMillis()));
        return this.usuarioRepository.save(usuario);
    }

}
