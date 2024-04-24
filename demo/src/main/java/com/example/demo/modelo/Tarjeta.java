package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Tarjeta {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Double cantidad;
}