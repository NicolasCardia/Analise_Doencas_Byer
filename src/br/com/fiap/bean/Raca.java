package br.com.fiap.bean;
public class Raca {

    private int cd_raca;

    private String nm_raca;




    public Raca(int cd_raca, String nm_raca) {
        super();
        this.cd_raca = cd_raca;
        this.nm_raca = nm_raca;
    }

    public Raca() {
        super();
    }

    public int getCd_raca() {
        return cd_raca;
    }

    public void setCd_raca(int cd_raca) {
        this.cd_raca = cd_raca;
    }

    public String getNm_raca() {
        return nm_raca;
    }

    public void setNm_raca(String nm_raca) {
        this.nm_raca = nm_raca;
    }
}