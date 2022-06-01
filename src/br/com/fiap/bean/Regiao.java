package br.com.fiap.bean;

import java.util.Calendar;

public class Regiao {

    private int cd_regiao;

    private Calendar data;

    private float peso;

    public Regiao (int cd_regiao, Calendar data, float peso){
        super();
        this.cd_regiao = cd_regiao;
        this.data = data;
        this.peso = peso;
    }

    public Regiao() {
        super();
    }

    public int getCd_regiao() {
        return cd_regiao;
    }

    public void setCd_regiao(int cd_regiao) {
        this.cd_regiao = cd_regiao;
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
