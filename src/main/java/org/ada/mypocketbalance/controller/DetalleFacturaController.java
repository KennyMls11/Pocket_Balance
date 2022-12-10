package org.ada.mypocketbalance.controller;
import org.ada.mypocketbalance.dto.DetalleFacturaDTO;
import org.ada.mypocketbalance.service.DetalleFacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/detallesFactura")

public class DetalleFacturaController {
    private final DetalleFacturaService detalleFacturaService;

    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody DetalleFacturaDTO detalleFacturaDTO) {

       detalleFacturaService.create(detalleFacturaDTO);

       return new ResponseEntity(detalleFacturaDTO.getId(),HttpStatus.CREATED);

    }
    @GetMapping("/{detalleFacturaId}")
    public ResponseEntity retrieveById(@PathVariable Integer IdProducto,
                                       @PathVariable Integer detalleFacturaId){
        DetalleFacturaDTO detalleFacturaDTO = detalleFacturaService.retrieveById(IdProducto, detalleFacturaId);

        return new ResponseEntity(detalleFacturaDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity retrieve() {

        return new ResponseEntity(detalleFacturaService.retrieveAll(), HttpStatus.OK);
    }
}

