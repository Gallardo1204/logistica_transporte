package com.logistica.transporte.service.cliente;

import com.logistica.transporte.dto.ClienteDTO;
import com.logistica.transporte.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getClientes();

    ClienteDTO getClientePorId(Long id);

    ClienteDTO crearCliente(ClienteDTO cliente);

    ClienteDTO actualizarCliente(Long id, ClienteDTO cliente);

    Object eliminarCliente(Long id);

}
