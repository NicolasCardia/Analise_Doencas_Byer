package br.com.fiap.bean;

public class ClasseSocial {

    private int cd_classe;

    private String nm_classe;

    public ClasseSocial (int cd_classe, String nm_classe){
        super();
        this.cd_classe = cd_classe;
        this.nm_classe = nm_classe;
    }

    public ClasseSocial() {
        super();
    }

    public int getCd_classe() {
        return cd_classe;
    }

    public void setCd_classe(int cd_classe) {
        this.cd_classe = cd_classe;
    }

    public String getNm_classe() {
        return nm_classe;
    }

    public void setNm_classe(String nm_classe) {
        this.nm_classe = nm_classe;
    }

}
