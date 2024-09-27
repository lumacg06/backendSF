package com.backendSF.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }
}
