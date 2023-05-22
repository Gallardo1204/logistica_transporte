package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.LogisticaMaritimaDTO;
import com.logistica.transporte.entity.LogisticaMaritima;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogisticaMaritimaMapper {

    LogisticaMaritima toEntity(LogisticaMaritimaDTO logisticaMaritimaDTO);

    LogisticaMaritimaDTO toDto(LogisticaMaritima logisticaMaritima);

}
