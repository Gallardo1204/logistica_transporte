package com.logistica.transporte.controller;

import com.logistica.transporte.dto.LogisticaTerrestreDTO;
import com.logistica.transporte.dto.RespuestaGenericaDTO;
import com.logistica.transporte.service.logistica_terrestre.LogisticaTerrestreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/logistica-terrestre")
public class LogisticaTerrestreController {

    private final LogisticaTerrestreService logisticaTerrestreService;


    @GetMapping
    public ResponseEntity<RespuestaGenericaDTO> getLogisticasTerrestres() {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(logisticaTerrestreService.getLogisticasTerrestres()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> getLogisticaTerrestrePorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(logisticaTerrestreService.getLogisticaTerrestrePorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenericaDTO> crearLogisticaTerrestre(@Valid @RequestBody LogisticaTerrestreDTO logisticaTerrestre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RespuestaGenericaDTO.builder()
                .data(logisticaTerrestreService.crearLogisticaTerrestre(logisticaTerrestre))
                .mensaje("Logistica Terrestre creada exitosamente").build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> actualizarLogisticaTerrestre(@PathVariable("id") Long id, @Valid @RequestBody LogisticaTerrestreDTO logisticaTerrestre) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(logisticaTerrestreService.actualizarLogisticaTerrestre(id, logisticaTerrestre))
                .mensaje("Logistica Terrestre actualizada correctamente").build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> eliminarLogisticaTerrestre(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(logisticaTerrestreService.eliminarLogisticaTerrestre(id))
                .mensaje("Logistica Terrestre eliminada exitosamente").build());
    }

}
