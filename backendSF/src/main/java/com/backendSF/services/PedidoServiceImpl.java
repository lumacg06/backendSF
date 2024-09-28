package com.backendSF.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendSF.models.Pedido;
import com.backendSF.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> buscarPorFecha(String fecha) {
        // Implementación del método
    }

    @Override
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        // Validar que el pedido tenga todos los campos requeridos
        if (pedido.getFecha() == null || pedido.getTotal() == null || pedido.getEstado() == null || pedido.getFormaPago() == null) {
            throw new RuntimeException("El pedido debe tener todos los campos requeridos");
        }
        
        // Guardar el pedido en la base de datos
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido nuevoPedido) {
        Pedido pedido = obtenerPorId(id);
        if (pedido != null) {
            pedido.setFecha(nuevoPedido.getFecha());
            pedido.setTotal(nuevoPedido.getTotal());
            pedido.setEstado(nuevoPedido.getEstado());
            pedido.setFormaPago(nuevoPedido.getFormaPago());
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> getPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        // add pedidos to the list
        pedidos.add(new Pedido("pedido1"));
        pedidos.add(new Pedido("pedido2"));
        return pedidos;
    }
}