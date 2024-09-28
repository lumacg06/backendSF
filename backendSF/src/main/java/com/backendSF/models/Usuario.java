package com.backendSF.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String rol;
    private String direccion;
    private String telefono;
}