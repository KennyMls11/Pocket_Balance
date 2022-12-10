package org.ada.mypocketbalance.service;


import org.ada.mypocketbalance.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;


    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


}
