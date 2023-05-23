package com.logistica.transporte.service.usuario;

import com.logistica.transporte.dto.UsuarioDTO;
import com.logistica.transporte.entity.Usuario;
import com.logistica.transporte.entity.security.Role;
import com.logistica.transporte.exception.ServiceException;
import com.logistica.transporte.mapper.UsuarioMapper;
import com.logistica.transporte.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByCorreo(usuarioDTO.getCorreo());
        if (usuarioEncontrado.isPresent())
            throw new ServiceException(messageSource.getMessage("usuario.correo.existing", null, Locale.getDefault())
                    .replace("#correo", usuarioDTO.getCorreo()));

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setActive(true);
        usuario.setRole(Role.USER);
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        UsuarioDTO returnDto = this.usuarioMapper.toDto(usuarioRepository.save(usuario));
        returnDto.setPassword(null);
        
        return returnDto;
    }

    @Override
    public UsuarioDTO findById(String id) {
        return this.usuarioRepository.findById(id)
                .map(usuario -> Optional.of(this.usuarioMapper.toDto(usuario)).map(usuarioDTO -> {
                    usuarioDTO.setPassword(null);
                    return usuarioDTO;
                }).get())
                .orElseThrow(() -> new ServiceException(this.messageSource.getMessage("usuario.id.nonexisting", null, Locale.getDefault())
                        .replace("id", id)));
    }

}
