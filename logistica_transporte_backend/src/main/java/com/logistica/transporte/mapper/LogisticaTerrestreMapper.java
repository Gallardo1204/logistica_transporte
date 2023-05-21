package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.LogisticaTerrestreDTO;
import com.logistica.transporte.entity.LogisticaTerrestre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogisticaTerrestreMapper {

    LogisticaTerrestre toEntity(LogisticaTerrestreDTO logisticaTerrestreDTO);

    LogisticaTerrestreDTO toDto(LogisticaTerrestre logisticaTerrestre);

}
