package org.ada.mypocketbalance.dto;

public class DetalleFacturaDTO {

    private  int id;
    private int cantidadPedida;
    private int precioTotal;

    public DetalleFacturaDTO(int ID, int cantidadPedida, int precioTotal) {
        this.id = id;
        this.cantidadPedida = cantidadPedida;
        this.precioTotal = precioTotal;
    }

    public int getID() {
        return id;
    }

    public int getcantidadPedida() {
        return cantidadPedida;
    }

    public int getprecioTotal() {
        return precioTotal;
    }
}
