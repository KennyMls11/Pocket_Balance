package org.ada.mypocketbalance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class DetalleFacturaDTO {

    private int id;
    @JsonAlias("cantidad_pedida")
    private int cantidadPedida;
    @JsonAlias ("precio_total")
    private double precioTotal;
    @JsonAlias ("id_factura")
    private Integer idFactura;
    @JsonAlias ("id_producto")
    private Integer idProducto;


    public DetalleFacturaDTO() {
    }

    public DetalleFacturaDTO(int id, int cantidadPedida, Double precioTotal) {
        this.id = id;
        this.cantidadPedida = cantidadPedida;
        this.precioTotal = precioTotal;
    }

    public DetalleFacturaDTO(int cantidadPedida, double precioTotal, Integer idProducto, Integer idFactura) {
        this.cantidadPedida = cantidadPedida;
        this.precioTotal = precioTotal;
        this.idProducto = idProducto;
        this.idFactura = idFactura;
    }


    public int getId() {
        return id;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }


    public Double getPrecioTotal() {
        return precioTotal;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setId(int id) {
        this.id = id;
    }
}