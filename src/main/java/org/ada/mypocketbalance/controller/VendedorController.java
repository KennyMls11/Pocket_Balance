package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.dto.VendedorDTO;
import org.ada.mypocketbalance.service.ProductoService;
import org.ada.mypocketbalance.service.VendedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {

        this.vendedorService = vendedorService;
    }
    @PostMapping
    public ResponseEntity create
            (@RequestBody VendedorDTO vendedorDTO) {

        VendedorDTO createdVendedorDTO = vendedorService.create(vendedorDTO);

        return new ResponseEntity(vendedorDTO.getId(), HttpStatus.CREATED);

    }

    @DeleteMapping("/{vendedorId}")
    public ResponseEntity delete(@PathVariable Integer vendedorId) {
        vendedorService.delete(vendedorId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(vendedorService.retrieveAll(), HttpStatus.OK);
    }

}

