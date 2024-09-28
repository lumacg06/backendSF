package com.backendSF.services;

import java.util.List;
import com.backendSF.models.Producto;

public interface ProductoService {
    
    List<Producto> buscarPorNombre(String nombre);
    List<Producto> obtenerTodos();
    Producto obtenerPorId(Long id);
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto nuevoProducto);
    void eliminarProducto(Long id);
    
}