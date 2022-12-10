package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.exceptions.ExistingResourceException;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.ClienteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

        private final ClienteRepository clienteRepository;
        private Cliente clienteDTO;

        public ClienteService(ClienteRepository clienteRepository) {

                this.clienteRepository = clienteRepository;
        }

        public List<ClienteDTO> retrieveAll() {

                List<Cliente>clientes = clienteRepository.findAll();

                return clientes.stream()
                        .map(cliente -> mapToDTO(cliente))
                        .collect(Collectors.toList());
        }


        private ClienteDTO mapToDTO(Cliente cliente) {

                ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getCuil(), cliente.getNombre(),
                        cliente.getTelefono(), cliente.getDireccion());

                return clienteDTO;
        }

        private Cliente mapToEntity(ClienteDTO clienteDTO) {
                Cliente cliente = new Cliente(clienteDTO.getId(),clienteDTO.getCuil(),clienteDTO.getNombre(),
                        clienteDTO.getTelefono(),clienteDTO.getDireccion());

                return cliente;


        }

        public ClienteDTO create(ClienteDTO clienteDTO) {
                Cliente cliente = mapToEntity(clienteDTO);
                checkForExistingCliente(cliente.getId());
                cliente = clienteRepository.save(cliente);

                return clienteDTO;
        }

        private void checkForExistingCliente (Integer clienteId) {
                if (clienteRepository.existsById(clienteId)) {
                        throw new ExistingResourceException();
                }
        }


        public void delete(Integer clienteId) {
                try {
                        clienteRepository.deleteById(clienteId);
                } catch (EmptyResultDataAccessException e){
                        throw new ResourceNotFoundException();
                }
        }
}






