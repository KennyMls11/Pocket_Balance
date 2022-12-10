package org.ada.mypocketbalance.dto;

import java.time.LocalDate;

public class FacturaDTO {

    private Integer id;
    private int numeroFactura;
    private float totalFactura;
    private LocalDate fecha;

    public FacturaDTO(Integer id, int numeroFactura, float totalFactura, LocalDate fecha) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
