package br.com.fiap.bean;

public class Regiao {

    private int cd_regiao;

    private String nm_regiao;

    public Regiao (int cd_regiao, String nm_regiao){
        super();
        this.cd_regiao = cd_regiao;
        this.nm_regiao = nm_regiao;
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

    public String getNm_regiao() {
        return nm_regiao;
    }

    public void setNm_regiao(String nm_regiao) {
        this.nm_regiao = nm_regiao;
    }
}