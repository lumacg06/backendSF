package com.backendSF.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private Integer stock;
    private String estado;

}