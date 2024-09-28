package com.backendSF.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendSF.models.Producto;
import com.backendSF.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El producto con el ID " + id + " no existe"));
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        if (productoRepository.existsById(id)) {
            nuevoProducto.setId(id);
            return productoRepository.save(nuevoProducto);
        } else {
            throw new IllegalArgumentException("El producto con el ID " + id + " no existe");
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}