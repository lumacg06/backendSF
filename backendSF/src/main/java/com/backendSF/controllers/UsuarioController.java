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

import com.backendSF.models.Usuario;
import com.backendSF.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //Metodo GET
    @GetMapping
    public List<Usuario> buscaUsuarios(@RequestParam (required = false)String nombre){
        if (nombre != null && !nombre.isEmpty()) {
            return usuarioService.buscarPorNombre(nombre);           
        } else {
          return usuarioService.obtenerTodos();  
        }
    }
    //Metodo GET por ID
    @GetMapping("/{id}")    
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
       Usuario usuario = usuarioService.obtenerPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
       
        } else {
           return ResponseEntity.notFound().build(); 
        }
    }
    
    //Metodo POST
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }
    
    //Metodo PUT
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario nuevoUsuario){
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, nuevoUsuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Metodo DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
}
}