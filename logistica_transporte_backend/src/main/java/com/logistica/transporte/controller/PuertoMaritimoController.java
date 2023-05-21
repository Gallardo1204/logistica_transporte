package com.logistica.transporte.controller;

import com.logistica.transporte.dto.PuertoMaritimoDTO;
import com.logistica.transporte.dto.RespuestaGenerica;
import com.logistica.transporte.service.puerto_maritimo.PuertoMaritimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/puertos-maritimos")
public class PuertoMaritimoController {

    private final PuertoMaritimoService puertoMaritimoService;

    @GetMapping
    public ResponseEntity<RespuestaGenerica> getPuertosMaritimos() {
        return ResponseEntity.ok().body(RespuestaGenerica.builder()
                .data(puertoMaritimoService.getPuertosMaritimos())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> getPuertoMaritimoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenerica.builder()
                .data(puertoMaritimoService.getPuertoMaritimoPorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenerica> crearPuertoMaritimo(@Valid @RequestBody PuertoMaritimoDTO puertoMaritimo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RespuestaGenerica.builder()
                .data(puertoMaritimoService.crearPuertoMaritimo(puertoMaritimo))
                .mensaje("Puerto Maritimo creado exitosamente")
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> actualizarProducto(@PathVariable("id") Long id, @Valid @RequestBody PuertoMaritimoDTO puertoMaritimo) {
        return ResponseEntity.ok(RespuestaGenerica.builder()
                .data(puertoMaritimoService.actualizarPuertoMaritimo(id, puertoMaritimo))
                .mensaje("Puerto Maritimo actualizado correctamente")
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> eliminarProducto(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenerica.builder()
                .data(puertoMaritimoService.eliminarPuertoMaritimo(id))
                .mensaje("Puerto Maritimo eliminado exitosamente")
                .build());
    }
}
