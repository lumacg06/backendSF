package com.backendSF.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "detalle_pedidos")
public class detallePedido {
    
    @Id
    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private Double precio;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}