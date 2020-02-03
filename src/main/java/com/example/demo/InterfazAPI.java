package com.example.demo;


import com.google.gson.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfazAPI {
    TransaccionManger transaccionManager;
    InterfazAPI(){
        transaccionManager = new TransaccionManger();
    }

    @PostMapping("/Push")
    public boolean push(String operacion, double monto){
        return transaccionManager.createTransaccion(operacion, monto);
    }

    @PostMapping("/PushMany")
    public boolean pushMany( String data){
        Gson g = new Gson();
        JsonObject jsonData = g.fromJson(data, JsonObject.class);
        for(int x=0; x<jsonData.getAsJsonArray("tipo").size(); x++){
            if(transaccionManager.createTransaccion(jsonData.getAsJsonArray("tipo").get(x).getAsString(), jsonData.getAsJsonArray("monto").get(x).getAsInt()) == false){
                return false;
            }
        }
        return true;
    }

    @GetMapping("/Saldo")
    public double saldo(){
        return transaccionManager.getSaldo();
    }

    @GetMapping("/TotalDebitos")
    public double totalDebitos(){
        return transaccionManager.getTotal_debito();
    }

    @GetMapping("/TotalCreditos")
    public double totalCreditos(){
        return transaccionManager.getTotal_credito();
    }

    @GetMapping("/PromedioDebito")
    public double promedioDebito(){
        return transaccionManager.getPromedio_debito();
    }

    @GetMapping("/MontoDebitoMayor")
    public double debitoMayor(){
        return transaccionManager.getDebitoMayor();
    }

    @GetMapping("/NumeroDeOperacionesCredito")
    public double numeroOperaciones(){
        return transaccionManager.getTransacciones_credito();
    }

    @GetMapping("/Arreglo")
    public String arreglo(){
        return transaccionManager.getArreglos();
    }

    @PostMapping("/removerCreditos")
    public boolean removerCreditos(String data){
        Gson g = new Gson();
        JsonObject jsonData = g.fromJson(data, JsonObject.class);
        return transaccionManager.remover("credito", jsonData);
    }

}
