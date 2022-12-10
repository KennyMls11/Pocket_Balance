package org.ada.mypocketbalance.entity;


import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "Factura")
public class Factura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column (name= "numero_factura",nullable = false)
    private Integer numeroFactura;

    @Column (name= "total_factura",nullable = false)
    private Double totalFactura;

    @Column (nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detallesFactura;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    public Factura() {
    }

    public Factura(Integer id, Integer numeroFactura, Double totalFactura, LocalDate fecha, List<DetalleFactura> detallesFactura, Cliente cliente, Vendedor vendedor) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.detallesFactura = detallesFactura;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Factura(Integer id, Integer numeroFactura, Double totalFactura, LocalDate fecha, Cliente cliente, Vendedor vendedor) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Factura(Integer id, Integer numeroFactura, Double totalFactura, LocalDate fecha) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
    }



    public Integer getId() {
        return id;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
}
