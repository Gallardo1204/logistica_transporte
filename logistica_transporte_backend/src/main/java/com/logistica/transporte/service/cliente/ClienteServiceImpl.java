package com.logistica.transporte.service.cliente;

import com.logistica.transporte.dto.ClienteDTO;
import com.logistica.transporte.entity.Cliente;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.mapper.ClienteMapper;
import com.logistica.transporte.repository.ClienteRepository;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final MensajesService mensajesService;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteDTO getClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        return clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO cliente) {
        Cliente clienteEntity = clienteRepository.save(clienteMapper.toEntity(cliente));
        cliente.setId(clienteEntity.getId());
        return cliente;
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO cliente) {
        Cliente clienteEntity = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));

        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setDireccion(cliente.getDireccion());
        clienteEntity.setNumIndetificacion(cliente.getNumIndetificacion());
        clienteEntity.setCorreo(cliente.getCorreo());
        clienteEntity.setTelefono(cliente.getTelefono());

        clienteRepository.save(clienteEntity);
        return clienteMapper.toDto(clienteEntity);
    }

    @Override
    public Object eliminarCliente(Long id) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        clienteRepository.delete(cliente);
        return null;
    }

}
