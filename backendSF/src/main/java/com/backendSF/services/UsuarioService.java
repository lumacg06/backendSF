package com.backendSF.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
