package com.example.demo;


import java.time.LocalDateTime;

public class Transaccion {
    int id;
    String tipo;
    double monto;
    LocalDateTime fecha;

    Transaccion(String tipo, double monto, int id){
        this.monto = monto;
        this.tipo = tipo;
        this.id = id;
        this.fecha = LocalDateTime.now();
    }
}
