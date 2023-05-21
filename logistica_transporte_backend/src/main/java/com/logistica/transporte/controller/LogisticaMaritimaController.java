package com.logistica.transporte.controller;

import com.logistica.transporte.dto.LogisticaMaritimaDTO;
import com.logistica.transporte.dto.RespuestaGenerica;
import com.logistica.transporte.service.logistica_maritima.LogisticaMaritimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/logistica-maritima")
public class LogisticaMaritimaController {

    private final LogisticaMaritimaService logisticaMaritimaService;


    @GetMapping
    public ResponseEntity<RespuestaGenerica> getLogisticasMaritimas() {
        return ResponseEntity.ok().body(RespuestaGenerica.builder().data(logisticaMaritimaService.getLogisticasMaritimas()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> getLogisticaMaritimaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenerica.builder().data(logisticaMaritimaService.getLogisticaMaritimaPorId(id)).build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenerica> crearLogisticaMaritima(@Valid @RequestBody LogisticaMaritimaDTO logisticaMaritima) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RespuestaGenerica.builder().data(logisticaMaritimaService.crearLogisticaMaritima(logisticaMaritima)).mensaje("Logistica Maritima creada exitosamente").build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> actualizarLogisticaMaritima(@PathVariable("id") Long id, @Valid @RequestBody LogisticaMaritimaDTO logisticaMaritima) {
        return ResponseEntity.ok(RespuestaGenerica.builder().data(logisticaMaritimaService.actualizarLogisticaMaritima(id, logisticaMaritima)).mensaje("Logistica Maritima actualizada correctamente").build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenerica> eliminarLogisticaMaritima(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenerica.builder().data(logisticaMaritimaService.eliminarLogisticaMaritima(id)).mensaje("Logistica Maritima eliminada exitosamente").build());
    }

}
