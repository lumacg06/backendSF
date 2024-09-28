package com.backendSF.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendSF.models.Pedido;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNombre(String nombre);
}