package com.logistica.transporte.service.logistica_terrestre;

import com.logistica.transporte.dto.LogisticaTerrestreDTO;
import com.logistica.transporte.entity.LogisticaTerrestre;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.mapper.LogisticaTerrestreMapper;
import com.logistica.transporte.repository.LogisticaTerrestreRepository;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogisticaTerrestreServiceImpl implements LogisticaTerrestreService {

    private final LogisticaTerrestreRepository logisticaTerrestreRepository;
    private final LogisticaTerrestreMapper logisticaTerrestreMapper;
    private final MensajesService mensajesService;


    @Override
    public List<LogisticaTerrestre> getLogisticasTerrestres() {
        return logisticaTerrestreRepository.findAll();
    }

    @Override
    public LogisticaTerrestreDTO getLogisticaTerrestrePorId(Long id) {
        LogisticaTerrestre logisticaTerrestre = logisticaTerrestreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        return logisticaTerrestreMapper.toDto(logisticaTerrestre);
    }

    @Override
    public LogisticaTerrestreDTO crearLogisticaTerrestre(LogisticaTerrestreDTO logisticaTerrestre) {
        LogisticaTerrestre logisticaTerrestreEntity = logisticaTerrestreRepository.save(logisticaTerrestreMapper.toEntity(logisticaTerrestre));
        logisticaTerrestre.setId(logisticaTerrestreEntity.getId());
        return logisticaTerrestre;
    }

    @Override
    public LogisticaTerrestreDTO actualizarLogisticaTerrestre(Long id, LogisticaTerrestreDTO logisticaTerrestre) {

        LogisticaTerrestre logisticaTerrestreEntity = logisticaTerrestreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));

        logisticaTerrestreEntity.setIdCliente(logisticaTerrestre.getIdCliente());
        logisticaTerrestreEntity.setIdProducto(logisticaTerrestre.getIdProducto());
        logisticaTerrestreEntity.setCantidadProducto(logisticaTerrestre.getCantidadProducto());
        logisticaTerrestreEntity.setFechaRegistro(logisticaTerrestre.getFechaRegistro());
        logisticaTerrestreEntity.setFechaEntrega(logisticaTerrestre.getFechaEntrega());
        logisticaTerrestreEntity.setIdBodega(logisticaTerrestre.getIdBodega());
        logisticaTerrestreEntity.setPrecioNormal(logisticaTerrestre.getPrecioNormal());
        logisticaTerrestreEntity.setPrecioDescuento(logisticaTerrestre.getPrecioDescuento());
        logisticaTerrestreEntity.setPlacaVehiculo(logisticaTerrestre.getPlacaVehiculo());
        logisticaTerrestreEntity.setNumeroGuia(logisticaTerrestre.getNumeroGuia());

        logisticaTerrestreRepository.save(logisticaTerrestreEntity);
        return logisticaTerrestreMapper.toDto(logisticaTerrestreEntity);
    }

    @Override
    public Object eliminarLogisticaTerrestre(Long id) {
        LogisticaTerrestre logisticaTerrestre = logisticaTerrestreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        logisticaTerrestreRepository.delete(logisticaTerrestre);
        return null;
    }
}
