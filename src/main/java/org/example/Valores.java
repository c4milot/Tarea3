package org.example;

public enum Valores {
    BEBIDA(500),
    DULCE(300);
    private int valor;
    Valores(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }

}
