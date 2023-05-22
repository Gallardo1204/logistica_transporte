package com.logistica.transporte.controller;

import com.logistica.transporte.dto.BodegaDTO;
import com.logistica.transporte.dto.RespuestaGenerica;
import com.logistica.transporte.service.bodega.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/bodegas")
public class BodegaController {

    private final BodegaService bodegaService;

    @GetMapping
    public ResponseEntity<RespuestaGenerica> getBodegas() {
        return ResponseEntity.ok().body(RespuestaGenerica.builder()
                .data(bodegaService.getBodegas())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> getBodegaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenerica.builder()
                .data(bodegaService.getBodegaPorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenerica> crearBodega(@Valid @RequestBody BodegaDTO bodega) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RespuestaGenerica.builder()
                        .data(bodegaService.crearBodega(bodega))
                        .mensaje("Bodega creada exitosamente")
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> actualizarBodega(@PathVariable("id") Long id, @Valid @RequestBody BodegaDTO bodega) {
        return ResponseEntity.ok(RespuestaGenerica.builder()
                .data(bodegaService.actualizarBodega(id, bodega))
                .mensaje("Bodega actualizada correctamente")
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> eliminarBodega(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenerica.builder()
                .data(bodegaService.eliminarBodega(id))
                .mensaje("Bodega eliminada exitosamente")
                .build());
    }


}
