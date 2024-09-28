package com.backendSF.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.backendSF.models.Pedido;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @EntityGraph(attributePaths = "detalles")
    List<Pedido> findByNombreContaining(@Param("nombre") String nombre);
}