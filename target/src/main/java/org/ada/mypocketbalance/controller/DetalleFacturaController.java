package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.service.DetalleFacturaService;
import org.ada.mypocketbalance.service.FacturaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/DetalleFactura")

public class DetalleFacturaController {
        private final DetalleFacturaService detalleFacturaService;

        public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
            this.detalleFacturaService = detalleFacturaService;
        }


    }

