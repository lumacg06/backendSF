package com.backendSF.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String rol;
    private String direccion;
    private String telefono;

}