package com.backendSF.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private Integer stock;
    private String estado;

}
