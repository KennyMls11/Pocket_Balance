package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private final DetalleFacturaRepository detalleFacturaRepository;


    public FacturaService(DetalleFacturaRepository detalleFacturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

    public void create(FacturaDTO facturaDTO) {
    }
}
