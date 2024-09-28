package com.backendSF.services;

import java.util.List;
import com.backendSF.models.Usuario;
import com.backendSF.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        Usuario usuario = obtenerPorId(id);
        if (usuario != null) {
            usuario.setNombre(nuevoUsuario.getNombre());
            usuario.setApellido(nuevoUsuario.getApellido());
            usuario.setEmail(nuevoUsuario.getEmail());
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}