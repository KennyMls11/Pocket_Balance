package org.ada.mypocketbalance.entity;

import javax.persistence.*;

@Entity
@Table(name = "Detalle_Factura")

public class DetalleFactura {

    @Id
    @Column(nullable = false)
    private int ID;

    @Column(nullable = false)
    private int CantidadPedida;

    @Column (nullable = false)
    private int PrecioTotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public DetalleFactura() {
    }

    public DetalleFactura(int id, int cantidadPedida, int precioTotal) {
        this.ID = id;
        CantidadPedida = cantidadPedida;
        PrecioTotal = precioTotal;
    }

    public int getId() {
        return ID;
    }

    public int getCantidadPedida() {
        return CantidadPedida;
    }

    public int getPrecioTotal() {
        return PrecioTotal;
    }
}
