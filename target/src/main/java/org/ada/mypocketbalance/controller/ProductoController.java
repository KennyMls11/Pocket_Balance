package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.service.FacturaService;
import org.ada.mypocketbalance.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Producto")

public class ProductoController {

        private final ProductoService productoService;

        public ProductoController(ProductoService productoService) {
            this.productoService = productoService;
        }

    }
