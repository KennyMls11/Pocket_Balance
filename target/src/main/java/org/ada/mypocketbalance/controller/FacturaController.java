package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/facturas")

public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping
    public ResponseEntity.BodyBuilder create(@RequestBody FacturaDTO facturaDTO) {
        facturaService.create(facturaDTO);
        return ResponseEntity.accepted();
    }

}
