package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.repository.VendedorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;


    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }
}
