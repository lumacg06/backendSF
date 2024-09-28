package com.backendSF.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendSF.models.Producto;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);
}