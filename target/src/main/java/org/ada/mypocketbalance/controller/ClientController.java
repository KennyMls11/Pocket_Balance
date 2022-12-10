package org.ada.mypocketbalance.controller;

import org.ada.mypocketbalance.service.ClientService;
import org.ada.mypocketbalance.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/Client")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {

        this.clientService = clientService;
    }
}
