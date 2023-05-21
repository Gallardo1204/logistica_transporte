package com.logistica.transporte.service.producto;

import com.logistica.transporte.dto.ProductoDTO;
import com.logistica.transporte.entity.Producto;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.mapper.ProductoMapper;
import com.logistica.transporte.repository.ProductoRepository;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    private final MensajesService mensajesService;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoDTO getProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        return productoMapper.toDto(producto);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) {
        Producto productoEntity = productoRepository.save(productoMapper.toEntity(producto));
        producto.setId(productoEntity.getId());
        return producto;
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO producto) {

        Producto productoEntity = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));

        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());

        productoRepository.save(productoEntity);
        return productoMapper.toDto(productoEntity);
    }

    @Override
    public Object eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        productoRepository.delete(producto);
        return null;
    }
}
