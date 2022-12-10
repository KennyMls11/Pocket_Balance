package org.ada.mypocketbalance.dto;

public class ProductoDTO {

    private Integer Id;
    private String descripcion;
    private Float precioCosto;
    private Float precioVenta;
    private Integer cantidadDisponible;

    public ProductoDTO(Integer id, String descripcion, Float precioCosto, Float precioVenta, Integer cantidadDisponible) {
        Id = id;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getPrecioCosto() {
        return precioCosto;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
}
