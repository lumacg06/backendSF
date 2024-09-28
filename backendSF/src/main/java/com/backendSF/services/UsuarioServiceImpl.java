package com.backendSF.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendSF.models.Usuario;
import com.backendSF.repositories.UsuarioRepository;

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
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El usuario con el ID " + id + " no existe"));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        if (usuarioRepository.existsById(id)) {
            nuevoUsuario.setId(id);
            return usuarioRepository.save(nuevoUsuario);
        } else {
            throw new IllegalArgumentException("El usuario con el ID " + id + " no existe");
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El usuario con el ID " + id + " no existe");
        }
    }
}