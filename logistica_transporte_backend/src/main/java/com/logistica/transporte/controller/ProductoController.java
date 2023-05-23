package com.logistica.transporte.controller;

import com.logistica.transporte.dto.ProductoDTO;
import com.logistica.transporte.dto.RespuestaGenericaDTO;
import com.logistica.transporte.service.producto.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<RespuestaGenericaDTO> getProductos() {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(productoService.getProductos())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> getProductoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(productoService.getProductoPorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenericaDTO> crearProducto(@Valid @RequestBody ProductoDTO producto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RespuestaGenericaDTO.builder()
                        .data(productoService.crearProducto(producto))
                        .mensaje("Producto creado exitosamente")
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> actualizarProducto(@PathVariable("id") Long id, @Valid @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(productoService.actualizarProducto(id, producto))
                .mensaje("Producto actualizado correctamente")
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> eliminarProducto(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(productoService.eliminarProducto(id))
                .mensaje("Producto eliminado exitosamente")
                .build());
    }

}
