package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.ClienteDTO;
import com.logistica.transporte.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDTO clienteDTO);

    ClienteDTO toDto(Cliente cliente);

}
