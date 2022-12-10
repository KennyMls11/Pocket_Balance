package org.ada.mypocketbalance.dto;

public class VendedorDTO {

    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;

    public VendedorDTO(Integer id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public VendedorDTO() {

    }

    public void setId(Integer id) {
        this.id = id;
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
}
