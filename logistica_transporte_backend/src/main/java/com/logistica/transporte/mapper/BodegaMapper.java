package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.BodegaDTO;
import com.logistica.transporte.entity.Bodega;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BodegaMapper {

    Bodega toEntity(BodegaDTO bodegaDTO);

    BodegaDTO toDto(Bodega bodega);

}
