package org.ada.mypocketbalance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Collection;
import java.util.List;

public class ProductoDTO {

    private Integer id;
    private String descripcion;
    @JsonAlias ("precio_costo")
    private Double precioCosto;
    @JsonAlias("precio_venta")
    private Double precioVenta;
    @JsonAlias("cantidad_disponible")
    private Integer cantidadDisponible;

    private List<DetalleFacturaDTO> detalleFacturaDTOS;

    public ProductoDTO(){

    }

    public ProductoDTO(Integer id, String descripcion, Double precioCosto, Double precioVenta, Integer cantidadDisponible, List<DetalleFacturaDTO> detalleFacturaDTOS) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
        this.detalleFacturaDTOS = detalleFacturaDTOS;
    }

    public ProductoDTO(Integer id, String descripcion, Double precioCosto, Double precioVenta, Integer cantidadDisponible) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public List<DetalleFacturaDTO> getDetalleFacturaDTOS() {
        return detalleFacturaDTOS;
    }
}
