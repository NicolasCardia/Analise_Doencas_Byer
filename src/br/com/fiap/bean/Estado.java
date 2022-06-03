package br.com.fiap.bean;

public class Estado {

    private int cd_estado;

    private String nm_estado;

    private int codigo_regiao;

    private int Regiao_cd_regiao;

    public Estado(int cd_estado, String nm_estado, int codigo_regiao, int Regiao_cd_regiao) {
        super();
        this.cd_estado = cd_estado;
        this.nm_estado = nm_estado;
        this.codigo_regiao = codigo_regiao;
        this.Regiao_cd_regiao = Regiao_cd_regiao;
    }

    public Estado() {
        super();
    }

    public int getCd_estado() {
        return cd_estado;
    }

    public void setCd_estado(int cd_estado) {
        this.cd_estado = cd_estado;
    }

    public String getNm_estado() {
        return nm_estado;
    }

    public void setNm_estado(String nm_estado) {
        this.nm_estado = nm_estado;
    }

    public int getCodigo_regiao() {
        return codigo_regiao;
    }

    public void setCodigo_regiao(int codigo_regiao) {
        this.codigo_regiao = codigo_regiao;
    }
    
    public int getRegiao_cd_regiao() {
        return Regiao_cd_regiao;
    }

    public void setRegiao_cd_regiao(int Regiao_cd_regiao) {
        this.Regiao_cd_regiao = Regiao_cd_regiao;
    }
}
