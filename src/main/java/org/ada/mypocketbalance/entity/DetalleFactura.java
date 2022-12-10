package org.ada.mypocketbalance.entity;

import javax.persistence.*;

@Entity
@Table(name = "Detalle_Factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad_pedida", nullable = false)
    private Integer cantidadPedida;


    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public DetalleFactura() {
    }


    public DetalleFactura(Integer cantidadPedida, Double precioTotal, Factura factura, Producto producto) {
        this.cantidadPedida = cantidadPedida;
        this.precioTotal = precioTotal;
        this.factura = factura;
        this.producto = producto;

    }

    public DetalleFactura(Integer cantidadPedida, Double precioTotal, Producto producto) {
        this.cantidadPedida = cantidadPedida;
        this.precioTotal = precioTotal;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCantidadPedida() {
        return cantidadPedida;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}



