package com.logistica.transporte.service.descuentos;

import org.springframework.stereotype.Service;

@Service
public class DescuentoServiceImpl implements DescuentoService{

    @Override
    public int cacularDescuento(double valor, int descuento) {

        double montoDescuento = valor * ((double) descuento / 100);
        double valorConDescuento = valor - montoDescuento;
        return (int) Math.round(valorConDescuento);

    }
}
