package org.ada.mypocketbalance.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "Factura")
public class Factura {

    @Id
    @Column (nullable = false)
    private Integer ID;

    @Column (nullable = false)
    private Integer NumeroFactura;

    @Column (nullable = false)
    private Float TotalFactura;

    @Column (nullable = false)
    private LocalDate Fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    public Factura() {
    }

    public Factura(Integer id, int numeroFactura, float totalFactura, LocalDate fecha) {
        this.ID = id;
        NumeroFactura = numeroFactura;
        TotalFactura = totalFactura;
        Fecha = fecha;
    }

    public Integer getId() {
        return ID;
    }

    public int getNumeroFactura() {
        return NumeroFactura;
    }

    public float getTotalFactura() {
        return TotalFactura;
    }

    public LocalDate getFecha() {
        return Fecha;
    }


}
