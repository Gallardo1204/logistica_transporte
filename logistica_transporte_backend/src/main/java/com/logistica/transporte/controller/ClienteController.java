package com.logistica.transporte.controller;

import com.logistica.transporte.dto.ClienteDTO;
import com.logistica.transporte.dto.RespuestaGenericaDTO;
import com.logistica.transporte.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private final ClienteService clienteService;


    @GetMapping
    public ResponseEntity<RespuestaGenericaDTO> getClientes() {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(clienteService.getClientes())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> getClientePorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(RespuestaGenericaDTO.builder()
                .data(clienteService.getClientePorId(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<RespuestaGenericaDTO> crearCliente(@Valid @RequestBody ClienteDTO cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RespuestaGenericaDTO.builder()
                        .data(clienteService.crearCliente(cliente))
                        .mensaje("Cliente creado exitosamente")
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> actualizarCliente(@PathVariable("id") Long id, @Valid @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(clienteService.actualizarCliente(id, cliente))
                .mensaje("Cliente actualizado correctamente")
                .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaGenericaDTO> eliminarCliente(@PathVariable("id") Long id) {
        return ResponseEntity.ok(RespuestaGenericaDTO.builder()
                .data(clienteService.eliminarCliente(id))
                .mensaje("Cliente eliminado exitosamente")
                .build());
    }

}
