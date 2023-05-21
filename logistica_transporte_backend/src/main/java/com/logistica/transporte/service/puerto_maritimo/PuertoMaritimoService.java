package com.logistica.transporte.service.puerto_maritimo;

import com.logistica.transporte.dto.PuertoMaritimoDTO;
import com.logistica.transporte.entity.PuertoMaritimo;

import java.util.List;

public interface PuertoMaritimoService {

    List<PuertoMaritimo> getPuertosMaritimos();

    PuertoMaritimoDTO getPuertoMaritimoPorId(Long id);

    PuertoMaritimoDTO crearPuertoMaritimo(PuertoMaritimoDTO puertoMaritimo);

    PuertoMaritimoDTO actualizarPuertoMaritimo(Long id, PuertoMaritimoDTO puertoMaritimo);

    Object eliminarPuertoMaritimo(Long id);
}
