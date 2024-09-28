package com.backendSF.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendSF.models.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);
}