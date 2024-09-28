package com.backendSF.models;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class detallePedido {
    
    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private Double precio;
    private Pedido pedido;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}