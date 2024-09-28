package com.backendSF.services;

import java.util.List;

import com.backendSF.models.Pedido;

public interface PedidoService {
    
    List<Pedido> buscarPorFecha(String fecha);
    List<Pedido> obtenerTodos();
    Pedido obtenerPorId(Long id);
    Pedido crearPedido(Pedido pedido);
    Pedido actualizarPedido(Long id, Pedido nuevoPedido);
    void eliminarPedido(Long id);
}