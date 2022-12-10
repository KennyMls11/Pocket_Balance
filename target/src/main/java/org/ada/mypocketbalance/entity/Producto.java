package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column (nullable = false)
    private Integer ID;

    @Column (nullable = false)
    private String Descripcion;

    @Column (nullable = false)
    private Float PrecioCosto;

    @Column (nullable = false)
    private Float PrecioVenta;

    @Column (nullable = false)
    private Integer CantidadDisponible;

    @OneToMany (mappedBy = "producto")
    private List<DetalleFactura> detallesFactura;

    public Producto(){
    }
    public Producto(Integer ID, String descripcion, float precioCosto, float precioVenta, Integer cantidadDisponible) {
        this.ID = ID;
        this.Descripcion = descripcion;
        this.PrecioCosto = precioCosto;
        this.PrecioVenta = precioVenta;
        this.CantidadDisponible = cantidadDisponible;
    }
}
