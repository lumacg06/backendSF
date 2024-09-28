package com.backendSF.services;

import java.util.List;
import com.backendSF.models.Usuario;

public interface UsuarioService {
    
    List<Usuario> buscarPorNombre(String nombre);
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario nuevoUsuario);
    void eliminarUsuario(Long id);
    
}