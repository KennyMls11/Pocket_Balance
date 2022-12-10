package org.ada.mypocketbalance.dto;


public class ClienteDTO {

    private Integer id;
    private Integer cuil;
    private String nombre;
    private Integer telefono;
    private String direccion;

    public ClienteDTO(Integer id, Integer cuil, String nombre, Integer telefono, String direccion) {
        this.id = id;
        this.cuil = cuil;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public ClienteDTO() {
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
}
