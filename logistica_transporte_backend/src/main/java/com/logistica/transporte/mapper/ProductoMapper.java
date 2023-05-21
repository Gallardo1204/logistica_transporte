package com.logistica.transporte.mapper;

import com.logistica.transporte.dto.ProductoDTO;
import com.logistica.transporte.entity.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toEntity(ProductoDTO productoDTO);

    ProductoDTO toDto(Producto producto);

}
