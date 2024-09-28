package com.backendSF.models;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Pedido {
    
    private Long id;
    private Date fecha;
    private Double total;
    private String estado;
    private String formaPago;
    private List<detallePedido> detalles;

    public void addDetalle(detallePedido detalle) {
        detalles.add(detalle);
        detalle.setPedido(this);
    }
}