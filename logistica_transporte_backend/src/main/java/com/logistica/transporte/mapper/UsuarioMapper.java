package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.UsuarioDTO;
import com.logistica.transporte.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDto(Usuario usuario);
}
