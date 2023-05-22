package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.PuertoMaritimoDTO;
import com.logistica.transporte.entity.PuertoMaritimo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PuertoMaritimoMapper {

    PuertoMaritimo toEntity(PuertoMaritimoDTO puertoMaritimoDTO);

    PuertoMaritimoDTO toDto(PuertoMaritimo puertoMaritimo);

}
