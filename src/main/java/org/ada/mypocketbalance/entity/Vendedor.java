package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @OneToMany (mappedBy = "vendedor")
    private List<Factura> facturas;

    public Vendedor(){

    }

    public Vendedor(Integer id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Vendedor(Integer id, String nombre, String telefono, String direccion, List<Factura> facturas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.facturas = facturas;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {

        return nombre;
    }

    public String getTelefono() {

        return telefono;
    }

    public String getDireccion() {

        return direccion;
    }

    public List<Factura> getFacturas() {

        return facturas;
    }
}
