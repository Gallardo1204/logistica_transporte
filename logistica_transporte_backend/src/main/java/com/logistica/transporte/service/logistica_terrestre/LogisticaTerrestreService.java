package com.logistica.transporte.service.logistica_terrestre;

import com.logistica.transporte.dto.LogisticaTerrestreDTO;
import com.logistica.transporte.entity.LogisticaTerrestre;

import java.util.List;

public interface LogisticaTerrestreService {

    List<LogisticaTerrestre> getLogisticasTerrestres();

    LogisticaTerrestreDTO getLogisticaTerrestrePorId(Long id);

    LogisticaTerrestreDTO crearLogisticaTerrestre(LogisticaTerrestreDTO logisticaTerrestre);

    LogisticaTerrestreDTO actualizarLogisticaTerrestre(Long id, LogisticaTerrestreDTO logisticaTerrestre);

    Object eliminarLogisticaTerrestre(Long id);
}
