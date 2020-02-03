package com.example.demo;


import java.time.LocalDateTime;

public class Transaccion {
    String tipo;
    double monto;
    LocalDateTime fecha;

    Transaccion(String tipo, double monto){
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }
}
