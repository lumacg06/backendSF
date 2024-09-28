package com.backendSF.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendSF.models.Producto;
import com.backendSF.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Metodo GET
    @GetMapping
    public List<Producto> buscaProductos(@RequestParam (required = false)String nombre){
        if (nombre != null && !nombre.isEmpty()) {
            return productoService.buscarPorNombre(nombre);           
        } else {
          return productoService.obtenerTodos();  
        }
    }
    //Metodo GET por ID
    @GetMapping("/{id}")    
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id){
       Producto producto = productoService.obtenerPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
       
        } else {
           return ResponseEntity.notFound().build(); 
        }
    }
    
    //Metodo POST
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    
    //Metodo PUT
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto nuevoProducto){
        Producto productoActualizado = productoService.actualizarProducto(id, nuevoProducto);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Metodo DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
}
}