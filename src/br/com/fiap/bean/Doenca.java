package br.com.fiap.bean;

public class Doenca {

    private int cd_doenca;

    private String nm_doenca;

    public Doenca(int cd_doenca, String nm_doenca) {
        super();
        this.cd_doenca = cd_doenca;
        this.nm_doenca = nm_doenca;
    }

    public Doenca() {
        super();
    }

    public int getCd_doenca() {
        return cd_doenca;
    }

    public void setCd_doenca(int cd_doenca) {
        this.cd_doenca = cd_doenca;
    }

    public String getNm_doenca() {
        return nm_doenca;
    }

    public void setNm_Doenca(String nm_doenca) {
        this.nm_doenca = nm_doenca;
    }

}
