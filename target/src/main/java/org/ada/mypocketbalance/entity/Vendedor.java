package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    @Column(nullable = false)
    private Integer ID;

    @Column(nullable = false)
    private String Nombre;

    @Column(nullable = false)
    private String Telefono;

    @Column(nullable = false)
    private String Direccion;

   @OneToMany (mappedBy = "vendedor")
    private List<Factura> facturas;

    public Vendedor(){

    }
    public Vendedor(Integer ID, String nombre, String telefono, String direccion) {
        this.ID = ID;
        this.Nombre = nombre;
        this.Telefono = telefono;
        this.Direccion = direccion;
    }

    public Integer getId() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }
}
