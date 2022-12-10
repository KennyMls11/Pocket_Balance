package org.ada.mypocketbalance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;
import java.util.List;

public class FacturaDTO {

    private Integer id;
    @JsonAlias ("numero_factura")
    private int numeroFactura;
    @JsonAlias ("total_factura")
    private Double totalFactura;
    @JsonAlias ("fecha")
    private String fecha; /*Cambiar a string y hacer logica*/
    @JsonAlias ("cliente_id")
    private Integer idCliente;
    @JsonAlias ("vendedor_id")
    private Integer idVendedor;

    private List<DetalleFacturaDTO> detalleFacturaDTOS;

    public FacturaDTO() {
    }

    public FacturaDTO(Integer id, int numeroFactura, Double totalFactura, String fecha) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
    }

    public FacturaDTO(Integer id, int numeroFactura, Double totalFactura, String fecha, Integer idCliente, Integer idVendedor) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public FacturaDTO(int numeroFactura, Double totalFactura, String fecha, Integer idCliente, Integer idVendedor, List<DetalleFacturaDTO> detalleFacturaDTOS) {
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.detalleFacturaDTOS = detalleFacturaDTOS;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public List<DetalleFacturaDTO> getDetalleFacturaDTOS() {
        return detalleFacturaDTOS;
    }
}

