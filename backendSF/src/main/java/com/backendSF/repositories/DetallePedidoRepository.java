package com.backendSF.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendSF.models.detallePedido;
import java.util.List;

public interface detallePedidoRepository extends JpaRepository<detallePedido, Long> {
    List<detallePedido> findByPedidoId(Long id);
}