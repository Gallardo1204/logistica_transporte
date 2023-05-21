package com.logistica.transporte.service.bodega;

import com.logistica.transporte.dto.BodegaDTO;
import com.logistica.transporte.entity.Bodega;

import java.util.List;

public interface BodegaService {

    List<Bodega> getBodegas();

    BodegaDTO getBodegaPorId(Long id);

    BodegaDTO crearBodega(BodegaDTO bodega);

    BodegaDTO actualizarBodega(Long id, BodegaDTO bodega);

    Object eliminarBodega(Long id);

}
