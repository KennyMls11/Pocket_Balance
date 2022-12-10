package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.dto.FacturaDTO;
import org.ada.mypocketbalance.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path="/facturas")


public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {

        this.facturaService = facturaService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody FacturaDTO facturaDTO) {
        facturaService.create(facturaDTO);
        return new ResponseEntity(facturaDTO.getId(), HttpStatus.CREATED);
    }


    @GetMapping("/{facturaId}")
    public ResponseEntity retrieveById(@PathVariable Integer facturaId) {
        FacturaDTO facturaDTO = facturaService.retrieveById(facturaId);

        return new ResponseEntity(facturaDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(facturaService.retrieveAll(), HttpStatus.OK);
    }

}




