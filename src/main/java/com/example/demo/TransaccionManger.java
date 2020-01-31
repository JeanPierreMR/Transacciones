package com.example.demo;

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
        /*Resizes de size of the array*/
        int size;
        size = (int)Math.floor(num_transacciones * percentage);
        Transaccion temporalTransacciones[] = new Transaccion[size];
        System.arraycopy(transacciones, 0, temporalTransacciones, 0, num_transacciones);
        transacciones = temporalTransacciones;
    }

    public void createTransaccion(String tipo, double monto){
        if(num_transacciones >= transacciones.length - 5){
            this.resizeTransacciones(1.2);
        }
        transacciones[num_transacciones] = new Transaccion(tipo, monto, num_transacciones);
    }


    public double getSaldo(){
        return total_credito - total_debito;
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
