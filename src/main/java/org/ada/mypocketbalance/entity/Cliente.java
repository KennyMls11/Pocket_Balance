package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "cliente")
public class Cliente {

    @Id
    private Integer id;

    @Column(nullable = false)
    private Integer cuil;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer telefono;

    @Column(nullable = false)
    private String direccion;


    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

    public Cliente() {
    }

    public Cliente(Integer id, Integer cuil, String nombre, Integer telefono, String direccion, List<Factura> facturas) {
        this.id = id;
        this.cuil = cuil;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.facturas = facturas;
    }

    public Cliente(Integer id, Integer cuil, String nombre, Integer telefono, String direccion) {
        this.id = id;
        this.cuil = cuil;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCuil() {
        return cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}
