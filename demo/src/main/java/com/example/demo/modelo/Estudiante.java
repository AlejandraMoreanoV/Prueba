package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Estudiante {

    @Setter @Getter
    public String nombre;

    @Setter @Getter
    public String apellido;

    @Setter @Getter
    public int edad;

    @Setter @Getter
    public int id;

}