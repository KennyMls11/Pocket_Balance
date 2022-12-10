package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.ClientDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

        private final ClientRepository clientRepository;

        public ClientService(ClientRepository clientRepository) {
                this.clientRepository = clientRepository;
        }

        public List<ClientDTO> retrieveAll() {

                List<Cliente> clients = clientRepository.findAll();

                return clients.stream()
                        .map(client -> mapToDTO(client))
                        .collect(Collectors.toList());
        }

        private ClientDTO mapToDTO(Cliente client) {

                ClientDTO clientDTO = new ClientDTO(client.getCuil(), client.getTelefono(), client.getNombre(),
                        client.getId(), client.getDireccion());

                return clientDTO;
        }

        private Cliente mapToEntity(ClientDTO clientDTO) {
                Cliente client = new Cliente(clientDTO.getCuil(), clientDTO.getTelefono(), clientDTO.getNombre(),
                        clientDTO.getId(), clientDTO.getDireccion());

                return client;

        }
}

