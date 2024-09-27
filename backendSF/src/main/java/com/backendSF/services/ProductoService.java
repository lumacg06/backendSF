package com.backendSF.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
}
