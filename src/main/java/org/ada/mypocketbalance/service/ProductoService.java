package org.ada.mypocketbalance.service;


import org.ada.mypocketbalance.dto.ClienteDTO;
import org.ada.mypocketbalance.dto.ProductoDTO;
import org.ada.mypocketbalance.dto.VendedorDTO;
import org.ada.mypocketbalance.entity.Cliente;
import org.ada.mypocketbalance.entity.Producto;
import org.ada.mypocketbalance.entity.Vendedor;
import org.ada.mypocketbalance.exceptions.ExistingResourceException;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.ProductoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final DetalleFacturaService detalleFacturaService;

    public ProductoService(ProductoRepository productoRepository, DetalleFacturaService detalleFacturaService) {
        this.productoRepository = productoRepository;
        this.detalleFacturaService = detalleFacturaService;
    }


    public List<ProductoDTO> retrieveAll() {

        List<Producto> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> mapToDTO(producto))
                .collect(Collectors.toList());
    }

    private ProductoDTO mapToDTO (Producto producto){
        ProductoDTO productoDTO = new ProductoDTO(producto.getId(), producto.getDescripcion(), producto.getPrecioCosto(),
                producto.getPrecioVenta(), producto.getCantidadDisponible());

        return productoDTO;
    }

    public ProductoDTO create(ProductoDTO productoDTO) {
        Producto producto = mapToEntity(productoDTO);
        checkForExistingProducto(producto.getId());
        producto = productoRepository.save(producto);
        if (!CollectionUtils.isEmpty(productoDTO.getDetalleFacturaDTOS())) {
            detalleFacturaService.create(productoDTO.getDetalleFacturaDTOS(),producto);
        }
        return productoDTO;
    }
            public void delete (Integer productoId){
                try {
                    productoRepository.deleteById(productoId);
                } catch (EmptyResultDataAccessException e) {
                    throw new ResourceNotFoundException();
                }
            }

    private void checkForExistingProducto(Integer productoId) {
        if (productoRepository.existsById(productoId)) {
            throw new ExistingResourceException();
        }

    }

    private Producto mapToEntity(ProductoDTO productoDTO){
        Producto producto= new Producto(productoDTO.getId(),productoDTO.getDescripcion(),productoDTO.getPrecioCosto(),
                productoDTO.getPrecioVenta(),productoDTO.getCantidadDisponible());
        return producto;
    }
    }



