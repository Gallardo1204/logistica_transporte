package com.logistica.transporte.controller;

import com.logistica.transporte.dto.ProductoDTO;
import com.logistica.transporte.dto.RespuestaGenerica;
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
    public ResponseEntity<RespuestaGenerica> getProductos() {
        return ResponseEntity.ok().body(RespuestaGenerica.builder()
                .data(productoService.getProductos())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> getProductoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenerica.builder()
                .data(productoService.getProductoPorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenerica> crearProducto(@Valid @RequestBody ProductoDTO producto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RespuestaGenerica.builder()
                        .data(productoService.crearProducto(producto))
                        .mensaje("Producto creado exitosamente")
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> actualizarProducto(@PathVariable("id") Long id, @Valid @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(RespuestaGenerica.builder()
                .data(productoService.actualizarProducto(id, producto))
                .mensaje("Producto actualizado correctamente")
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> eliminarProducto(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenerica.builder()
                .data(productoService.eliminarProducto(id))
                .mensaje("Producto eliminado exitosamente")
                .build());
    }

}
