package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.dto.VendedorDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.entity.Vendedor;
import org.ada.mypocketbalance.exceptions.ExistingResourceException;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.VendedorRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;


    public VendedorService(VendedorRepository vendedorRepository) {

        this.vendedorRepository = vendedorRepository;
    }
    public List<VendedorDTO> retrieveAll() {

        List<Vendedor> vendedores = vendedorRepository.findAll();

        return vendedores.stream()
                .map(vendedor-> mapToDTO(vendedor))
                .collect(Collectors.toList());
    }


    private VendedorDTO mapToDTO(Vendedor vendedor) {

        VendedorDTO vendedorDTO = new VendedorDTO(vendedor.getId(),vendedor.getNombre(),vendedor.getTelefono(), vendedor.getDireccion());

        return vendedorDTO;
    }

    private Vendedor mapToEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor(vendedorDTO.getId(),vendedorDTO.getNombre(),vendedorDTO.getTelefono(),vendedorDTO.getDireccion());

        return vendedor;

    }

    public VendedorDTO create(VendedorDTO vendedorDTO) {
        Vendedor vendedor = mapToEntity(vendedorDTO);
        checkForExistingVendedor(vendedor.getId());
        vendedor = vendedorRepository.save(vendedor);

        return vendedorDTO;
    }

    private void checkForExistingVendedor (Integer vendedorId) {
        if (vendedorRepository.existsById(vendedorId)) {
            throw new ExistingResourceException();
        }
    }


    public void delete(Integer vendedorId) {
        try {
            vendedorRepository.deleteById(vendedorId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }
}


