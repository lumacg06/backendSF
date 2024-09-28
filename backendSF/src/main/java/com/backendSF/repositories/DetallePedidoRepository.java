package com.backendSF.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendSF.models.detallePedido;
import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<detallePedido, Long> {
    List<detallePedido> findByPedidoId(Long id);
}