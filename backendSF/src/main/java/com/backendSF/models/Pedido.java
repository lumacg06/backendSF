package com.backendSF.models;

import java.sql.Date;
import java.util.List;

/* import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table; */
import java.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private Double total;
    private String estado;
    private String formaPago;
    
    @OneToMany(mappedBy = "pedido", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;
}