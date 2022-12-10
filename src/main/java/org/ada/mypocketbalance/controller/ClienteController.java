package org.ada.mypocketbalance.controller;

import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/clientes")

public class ClienteController {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity create
            (@RequestBody ClienteDTO clienteDTO) {

        ClienteDTO createdClienteDTO = clienteService.create(clienteDTO);

        return new ResponseEntity(clienteDTO.getId(), HttpStatus.CREATED);

    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity delete(@PathVariable Integer clienteId) {
        clienteService.delete(clienteId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(clienteService.retrieveAll(), HttpStatus.OK);
    }

}

