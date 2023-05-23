package com.logistica.transporte.controller;

import com.logistica.transporte.dto.PuertoMaritimoDTO;
import com.logistica.transporte.dto.RespuestaGenericaDTO;
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
    public ResponseEntity<RespuestaGenericaDTO> getPuertosMaritimos() {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(puertoMaritimoService.getPuertosMaritimos())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> getPuertoMaritimoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(puertoMaritimoService.getPuertoMaritimoPorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenericaDTO> crearPuertoMaritimo(@Valid @RequestBody PuertoMaritimoDTO puertoMaritimo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RespuestaGenericaDTO.builder()
                .data(puertoMaritimoService.crearPuertoMaritimo(puertoMaritimo))
                .mensaje("Puerto Maritimo creado exitosamente")
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> actualizarProducto(@PathVariable("id") Long id, @Valid @RequestBody PuertoMaritimoDTO puertoMaritimo) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(puertoMaritimoService.actualizarPuertoMaritimo(id, puertoMaritimo))
                .mensaje("Puerto Maritimo actualizado correctamente")
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> eliminarProducto(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(puertoMaritimoService.eliminarPuertoMaritimo(id))
                .mensaje("Puerto Maritimo eliminado exitosamente")
                .build());
    }
}
