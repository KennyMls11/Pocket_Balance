package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.dto.ProductoDTO;
import org.ada.mypocketbalance.dto.VendedorDTO;
import org.ada.mypocketbalance.service.FacturaService;
import org.ada.mypocketbalance.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/productos")

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @PostMapping
    public ResponseEntity create
            (@RequestBody ProductoDTO productoDTO) {

        ProductoDTO createdProductoDTO = productoService.create(productoDTO);

        return new ResponseEntity(productoDTO.getId(), HttpStatus.CREATED);

    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity delete(@PathVariable Integer productoId) {
        productoService.delete(productoId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(productoService.retrieveAll(), HttpStatus.OK);
    }

}


