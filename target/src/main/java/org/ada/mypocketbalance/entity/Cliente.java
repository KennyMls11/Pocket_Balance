package org.ada.mypocketbalance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Cliente")
public class Cliente {

    @Id
    @Column (nullable = false)
    private Integer ID;

    @Column (nullable = false)
    private Integer Cuil;

    @Column (nullable = false)
    private String Nombre;

    @Column (nullable = false)
    private Integer Telefono;

    @Column (nullable = false)
    private String Direccion;


    @OneToMany (mappedBy = "cliente")
    private List<Factura> facturas;
    public Cliente() {
    }
    public Cliente(Integer id, Integer cuil, String nombre, Integer telefono, String direccion) {
        this.ID = id;
        this.Cuil = cuil;
        this.Nombre = nombre;
        this.Telefono = telefono;
        this.Direccion = direccion;
    }

    public Integer getId() {
        return ID;
    }

    public Integer getCuil() {
        return Cuil;
    }

    public String getNombre() {
        return Nombre;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }
}
