package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.dto.DetalleFacturaDTO;
import org.ada.mypocketbalance.entity.*;
import org.ada.mypocketbalance.exceptions.ResourceNotAvaibe;
import org.ada.mypocketbalance.exceptions.ResourceNotFoundException;
import org.ada.mypocketbalance.repository.DetalleFacturaRepository;
import org.ada.mypocketbalance.repository.FacturaRepository;
import org.ada.mypocketbalance.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class DetalleFacturaService {

    private final DetalleFacturaRepository detalleFacturaRepository;
    private final ProductoRepository productoRepository;
    private final FacturaRepository facturaRepository;


    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository, ProductoRepository productoRepository, FacturaRepository facturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
        this.productoRepository = productoRepository;
        this.facturaRepository = facturaRepository;
    }

    public void create(List<DetalleFacturaDTO> detalleFacturaDTOS, Producto producto) {
        List<DetalleFactura> detalleFacturas = detalleFacturaDTOS.stream()
                .map(detalleFacturaDTO -> mapToEntity(detalleFacturaDTO, producto))
                .collect(Collectors.toList());
        detalleFacturaRepository.saveAll(detalleFacturas);
    }

    private DetalleFactura mapToEntity(DetalleFacturaDTO detalleFacturaDTO, Producto producto) {
        DetalleFactura detalleFactura = new DetalleFactura(detalleFacturaDTO.getCantidadPedida(), detalleFacturaDTO.getPrecioTotal(), producto);

        return detalleFactura;
    }

    public void create(DetalleFacturaDTO detalleFacturaDTO) {
        Optional<Factura> factura = facturaRepository.findById(detalleFacturaDTO.getIdFactura());
        Optional<Producto> producto = productoRepository.findById(detalleFacturaDTO.getIdProducto());


        if (producto.get().getCantidadDisponible() <= 0) {
            throw new ResourceNotFoundException("no tenemos stock disponible");
        }
        if (detalleFacturaDTO.getCantidadPedida() > producto.get().getCantidadDisponible()) {
            throw new ResourceNotAvaibe("la cantidad pedida supera nuestro stock disponible, intenta comprar : " + producto.get().getCantidadDisponible() + " .");
        }
        if (producto.isEmpty()) {
            throw new ResourceNotAvaibe("el producto no se encuentra");
        }
        if (factura.isEmpty()) {
            throw new ResourceNotFoundException("La factura no existe");
        }
        DetalleFactura detalleFactura = mapToEntity(detalleFacturaDTO, factura.get(), producto.get());
        detalleFacturaRepository.save(detalleFactura);
        detalleFacturaDTO.setId(detalleFactura.getId());
        producto.get().setCantidadDisponible(producto.get().getCantidadDisponible() - detalleFacturaDTO.getCantidadPedida());
        productoRepository.save(producto.get());
    }

    public DetalleFacturaDTO retrieveById(Integer idProducto, Integer detalleFacturaId) {
        if (!productoRepository.existsById(idProducto)) {
            throw new ResourceNotFoundException("El producto no está disponible");
        }
        Optional<DetalleFactura> detalleFactura = detalleFacturaRepository.findById(detalleFacturaId);
        if (detalleFactura.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(detalleFactura.get());
    }

    public List<DetalleFacturaDTO> retrieveAll() {
        List<DetalleFactura> detallesFactura = detalleFacturaRepository.findAll();

        return detallesFactura.stream()
                .map(detalleFactura -> mapToDTO(detalleFactura))
                .collect(Collectors.toList());
    }

    private DetalleFactura mapToEntity(DetalleFacturaDTO detalleFacturaDTO, Factura factura, Producto producto) {
        DetalleFactura detalleFactura = new DetalleFactura(detalleFacturaDTO.getCantidadPedida(), detalleFacturaDTO.getPrecioTotal(), factura, producto);

        return detalleFactura;
    }


    public DetalleFacturaDTO mapToDTO(DetalleFactura detalleFactura) {
        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO(detalleFactura.getCantidadPedida(), detalleFactura.getPrecioTotal()
                , detalleFactura.getProducto().getId(), detalleFactura.getFactura().getId());
        detalleFacturaDTO.setId(detalleFactura.getId());

        return detalleFacturaDTO;


    }
}


