package com.backendSF.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    private Long id;
    private Date fecha;
    private Double total;
    private String estado;
    private String formaPago;
    private String nombre;
    
    @OneToMany(mappedBy = "pedido")
    private List<detallePedido> detalles;

    public void addDetalle(detallePedido detalle) {
        detalles.add(detalle);
        detalle.setPedido(this);
    }
}