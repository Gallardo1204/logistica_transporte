package com.logistica.transporte.service.puerto_maritimo;

import com.logistica.transporte.dto.PuertoMaritimoDTO;
import com.logistica.transporte.entity.PuertoMaritimo;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.mapper.PuertoMaritimoMapper;
import com.logistica.transporte.repository.PuertoMaritimoRepository;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PuertoMaritimoServiceImpl implements PuertoMaritimoService {

    private final PuertoMaritimoRepository puertoMaritimoRepository;
    private final PuertoMaritimoMapper puertoMaritimoMapper;
    private final MensajesService mensajesService;

    @Override
    public List<PuertoMaritimo> getPuertosMaritimos() {
        return puertoMaritimoRepository.findAll();
    }

    @Override
    public PuertoMaritimoDTO getPuertoMaritimoPorId(Long id) {
        PuertoMaritimo puertoMaritimo = puertoMaritimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        return puertoMaritimoMapper.toDto(puertoMaritimo);
    }

    @Override
    public PuertoMaritimoDTO crearPuertoMaritimo(PuertoMaritimoDTO puertoMaritimo) {
        PuertoMaritimo puertoEntity = puertoMaritimoRepository.save(puertoMaritimoMapper.toEntity(puertoMaritimo));
        puertoMaritimo.setId(puertoEntity.getId());
        return puertoMaritimo;
    }

    @Override
    public PuertoMaritimoDTO actualizarPuertoMaritimo(Long id, PuertoMaritimoDTO puertoMaritimo) {

        PuertoMaritimo puertoMaritimoEntity = puertoMaritimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));

        puertoMaritimoEntity.setNombre(puertoMaritimo.getNombre());
        puertoMaritimoEntity.setDireccion(puertoMaritimo.getDireccion());

        puertoMaritimoRepository.save(puertoMaritimoEntity);
        return puertoMaritimoMapper.toDto(puertoMaritimoEntity);
    }

    @Override
    public Object eliminarPuertoMaritimo(Long id) {
        PuertoMaritimo puertoMaritimo = puertoMaritimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(mensajesService.getMensaje("global.resource.notfound")));
        puertoMaritimoRepository.delete(puertoMaritimo);
        return null;
    }
}
