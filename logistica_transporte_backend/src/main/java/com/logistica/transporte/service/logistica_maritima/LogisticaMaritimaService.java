package com.logistica.transporte.service.logistica_maritima;

import com.logistica.transporte.dto.LogisticaMaritimaDTO;
import com.logistica.transporte.entity.LogisticaMaritima;

import java.util.List;

public interface LogisticaMaritimaService {

    List<LogisticaMaritima> getLogisticasMaritimas();

    LogisticaMaritimaDTO getLogisticaMaritimaPorId(Long id);

    LogisticaMaritimaDTO crearLogisticaMaritima(LogisticaMaritimaDTO logisticaMaritima);

    LogisticaMaritimaDTO actualizarLogisticaMaritima(Long id, LogisticaMaritimaDTO logisticaMaritima);

    Object eliminarLogisticaMaritima(Long id);
}
