package com.logistica.transporte.service.security;


import com.logistica.transporte.config.security.JwtService;
import com.logistica.transporte.dto.UsuarioDTO;
import com.logistica.transporte.dto.security.AuthenticationRequest;
import com.logistica.transporte.entity.Usuario;
import com.logistica.transporte.entity.security.Role;
import com.logistica.transporte.mapper.UsuarioMapper;
import com.logistica.transporte.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final UsuarioService usuarioService;
    private final UsuarioSecurityService usuarioSecurityService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {

        var usuario = Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .correo(usuarioDTO.getCorreo())
                .password(passwordEncoder.encode(usuarioDTO.getPassword()))
                .role(Role.USER).build();

        var jwtToken = jwtService.generateToken(usuario);
        usuarioDTO.setLastLogin(new Date(System.currentTimeMillis()));
        usuarioDTO.setToken(jwtToken);
        UsuarioDTO usuarioRegistrado = usuarioService.crearUsuario(usuarioDTO);

        return usuarioRegistrado;
    }

    /**
     * Método para realizar login.
     * Se establece el nuevo token para el usuario para que pueda persistir
     *
     * @param request
     * @return
     */
    @Override
    public UsuarioDTO login(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword()));

        var usuario = usuarioSecurityService.findByCorreoForSecurity(request.getCorreo());

        String token = jwtService.generateToken(usuario);

        usuario.setToken(token);
        usuario = this.usuarioSecurityService.updateLastLogin(usuario);

        UsuarioDTO usuarioDTO = this.usuarioMapper.toDto(usuario);
        usuarioDTO.setPassword(null);

        return usuarioDTO;
    }
}
