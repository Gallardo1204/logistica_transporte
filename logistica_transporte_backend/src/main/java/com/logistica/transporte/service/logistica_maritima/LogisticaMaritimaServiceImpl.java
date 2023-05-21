package com.logistica.transporte.service.logistica_maritima;

import com.logistica.transporte.dto.LogisticaMaritimaDTO;
import com.logistica.transporte.entity.LogisticaMaritima;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.mapper.LogisticaMaritimaMapper;
import com.logistica.transporte.repository.LogisticaMaritimaRepository;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogisticaMaritimaServiceImpl implements LogisticaMaritimaService {

    private final LogisticaMaritimaRepository logisticaMaritimaRepository;
    private final LogisticaMaritimaMapper logisticaMaritimaMapper;
    private final MensajesService mensajesService;

    @Override
    public List<LogisticaMaritima> getLogisticasMaritimas() {
        return logisticaMaritimaRepository.findAll();
    }

    @Override
    public LogisticaMaritimaDTO getLogisticaMaritimaPorId(Long id) {
        LogisticaMaritima logisticaMaritima = logisticaMaritimaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        return logisticaMaritimaMapper.toDto(logisticaMaritima);
    }

    @Override
    public LogisticaMaritimaDTO crearLogisticaMaritima(LogisticaMaritimaDTO logisticaMaritima) {
        LogisticaMaritima logisticaMaritimaEntity = logisticaMaritimaRepository.save(logisticaMaritimaMapper.toEntity(logisticaMaritima));
        logisticaMaritima.setId(logisticaMaritimaEntity.getId());
        return logisticaMaritima;
    }

    @Override
    public LogisticaMaritimaDTO actualizarLogisticaMaritima(Long id, LogisticaMaritimaDTO logisticaMaritima) {

        LogisticaMaritima logisticaMaritimaEntity = logisticaMaritimaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));

        logisticaMaritimaEntity.setIdCliente(logisticaMaritima.getIdCliente());
        logisticaMaritimaEntity.setIdProducto(logisticaMaritima.getIdProducto());
        logisticaMaritimaEntity.setCantidadProducto(logisticaMaritima.getCantidadProducto());
        logisticaMaritimaEntity.setFechaRegistro(logisticaMaritima.getFechaRegistro());
        logisticaMaritimaEntity.setFechaEntrega(logisticaMaritima.getFechaEntrega());
        logisticaMaritimaEntity.setIdPuerto(logisticaMaritima.getIdPuerto());
        logisticaMaritimaEntity.setPrecioNormal(logisticaMaritima.getPrecioNormal());
        logisticaMaritimaEntity.setPrecioDescuento(logisticaMaritima.getPrecioDescuento());
        logisticaMaritimaEntity.setNumeroFlota(logisticaMaritima.getNumeroFlota());
        logisticaMaritimaEntity.setNumeroGuia(logisticaMaritima.getNumeroGuia());

        logisticaMaritimaRepository.save(logisticaMaritimaEntity);
        return logisticaMaritimaMapper.toDto(logisticaMaritimaEntity);

    }

    @Override
    public Object eliminarLogisticaMaritima(Long id) {
        LogisticaMaritima logisticaMaritima = logisticaMaritimaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        logisticaMaritimaRepository.delete(logisticaMaritima);
        return null;
    }
}
