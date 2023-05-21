package com.logistica.transporte.service.producto;

import com.logistica.transporte.dto.ProductoDTO;
import com.logistica.transporte.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getProductos();

    ProductoDTO getProductoPorId(Long id);

    ProductoDTO crearProducto(ProductoDTO producto);

    ProductoDTO actualizarProducto(Long id, ProductoDTO producto);

    Object eliminarProducto(Long id);
}
