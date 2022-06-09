package br.com.fiap.bean;

import java.util.Calendar;

public class Peso {

    private int codigo;

    private Calendar data;

    private float peso;

    public Peso (int codigo, Calendar data, float peso){
        super();
        this.codigo = codigo;
        this.data = data;
        this.peso = peso;
    }

    public Peso() {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
