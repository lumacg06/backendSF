package com.backendSF.services;

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
    public List<Pedido> buscarPorNombre(String nombre) {
        return pedidoRepository.findByNombre(nombre);
    }

    @Override
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El pedido con el ID " + id + " no existe"));
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        if (pedido.getFecha() == null || pedido.getTotal() == null || pedido.getEstado() == null || pedido.getFormaPago() == null) {
            throw new IllegalArgumentException("El pedido debe tener todos los campos requeridos");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido nuevoPedido) {
        if (pedidoRepository.existsById(id)) {
            nuevoPedido.setId(id);
            return pedidoRepository.save(nuevoPedido);
        } else {
            throw new IllegalArgumentException("El pedido con el ID " + id + " no existe");
        }
    }

    @Override
    public void eliminarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El pedido con el ID " + id + " no existe");
        }
    }
}