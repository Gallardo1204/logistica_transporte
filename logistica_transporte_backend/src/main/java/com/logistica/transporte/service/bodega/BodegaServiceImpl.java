package com.logistica.transporte.service.bodega;

import com.logistica.transporte.dto.BodegaDTO;
import com.logistica.transporte.entity.Bodega;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.mapper.BodegaMapper;
import com.logistica.transporte.repository.BodegaRepository;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService {

    private final BodegaRepository bodegaRepository;
    private final BodegaMapper bodegaMapper;
    private final MensajesService mensajesService;

    @Override
    public List<Bodega> getBodegas() {
        return bodegaRepository.findAll();
    }

    @Override
    public BodegaDTO getBodegaPorId(Long id) {
        Bodega bodega = bodegaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        return bodegaMapper.toDto(bodega);
    }

    @Override
    public BodegaDTO crearBodega(BodegaDTO bodega) {
        Bodega bodegaEntity = bodegaRepository.save(bodegaMapper.toEntity(bodega));
        bodega.setId(bodegaEntity.getId());
        return bodega;
    }

    @Override
    public BodegaDTO actualizarBodega(Long id, BodegaDTO bodega) {

        Bodega bodegaEntity = bodegaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));

        bodegaEntity.setNombre(bodega.getNombre());
        bodegaEntity.setDireccion(bodega.getDireccion());

        bodegaRepository.save(bodegaEntity);
        return bodegaMapper.toDto(bodegaEntity);
    }

    @Override
    public Object eliminarBodega(Long id) {

        Bodega bodega = bodegaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        bodegaRepository.delete(bodega);
        return null;
    }

}
