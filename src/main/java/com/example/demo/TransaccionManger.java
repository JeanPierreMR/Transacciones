package com.example.demo;

import com.google.gson.JsonObject;

import java.util.Arrays;

public class TransaccionManger {
    private int transacciones_credito;
    private int transacciones_debito;
    private double total_credito;
    private double total_debito;
    private int num_transacciones;
    private Transaccion transacciones[];

    TransaccionManger(){
        transacciones_debito = 0;
        transacciones_credito = 0;
        total_credito = 0;
        total_debito = 0;
        transacciones = new Transaccion[200];
    }
    private void resizeTransacciones(double percentage){
        /*Resizes de size of the array
        * it creates a bigger array and copy the data there
        * then it changes the old array*/
        int size;
        size = (int)Math.floor(num_transacciones * percentage);//makes the new size percentage bigger
        Transaccion temporalTransacciones[] = new Transaccion[size];
        System.arraycopy(transacciones, 0, temporalTransacciones, 0, num_transacciones);
        transacciones = temporalTransacciones;
    }

    public boolean createTransaccion(String tipo, double monto){
        if(num_transacciones >= transacciones.length - 5){
            this.resizeTransacciones(1.2);
        }
        if(tipo.equals("credito")){
            total_credito +=  monto;
            transacciones_credito++;
        }else if (tipo.equals("debito")){
            total_debito +=  monto;
            transacciones_debito++;
        }else{
            return false;
        }
        transacciones[num_transacciones] = new Transaccion(tipo, monto);
        num_transacciones++;
        return true;
    }

    public double getSaldo(){
        return total_credito - total_debito;
    }

    public double getDebitoMayor(){
        int i = 0;
        double mayor = 0;
        while(i < num_transacciones){
            if(transacciones[i].getTipo().equals("debito")){

                if(mayor < transacciones[i].getMonto()){
                    mayor = transacciones[i].getMonto();
                }
            }
            i++;
        }
        return mayor;
    }

    public double getPromedio_credito(){
        return total_credito / transacciones_credito;
    }
    public double getPromedio_debito(){
        return total_debito / transacciones_debito;
    }
    public String getArreglos(){

        return Arrays.toString(transacciones);
    }

    public boolean remover(String tipo, JsonObject numeros){
        int i = 0;
        int x = 0;
        while(x < num_transacciones){
            x++;
            //revisa si es del tipo requerido
            if(transacciones[i].getTipo().equals(tipo)){
                i++;
                //revisa si es el numero de operacion correcto
                for(int y = 0; y<numeros.size(); y++)
                if(i == numeros.getAsJsonArray("numeros").get(y).getAsInt()){
                    delete(i);
                }
            }
        }
        return true;

    }
    public void delete(int i){
        for (int j = i; j < num_transacciones-1; j++) {
            transacciones[j] = transacciones[j + 1];
        }
    }

    public int getTransacciones_credito() {
        return transacciones_credito;
    }
    public int getTransacciones_debito() {
        return transacciones_debito;
    }
    public double getTotal_credito() {
        return total_credito;
    }
    public double getTotal_debito() {
        return total_debito;
    }
    public int getNum_transacciones() {
        return num_transacciones;
    }
}
