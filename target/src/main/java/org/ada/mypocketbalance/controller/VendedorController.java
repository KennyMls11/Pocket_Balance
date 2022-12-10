package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.service.ProductoService;
import org.ada.mypocketbalance.service.VendedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Vendedor")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }
}
