package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfazAPI {
    TransaccionManger transaccionManager;
    InterfazAPI(){
        transaccionManager = new TransaccionManger();
    }
    @PostMapping("/push")
    public boolean push(String operacion, double monto){
        transaccionManager.createTransaccion(operacion, monto);
        return true;
    }
    @GetMapping("/Saldo")
    public double pop(){
        return transaccionManager.getSaldo();
    }
}
