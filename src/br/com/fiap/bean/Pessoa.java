package br.com.fiap.bean;

public class Pessoa {

    private int cd_pessoa;

    private String cpf;

    private int cd_estado;

    private int cd_doenca;

    private int cd_raca;

    private String genero;

    private String gravida;

    private int cd_classe;

    private int idade;

    private int cd_gravidade;
    public Pessoa(int cd_pessoa,String cpf, int cd_estado, int cd_doenca, int cd_raca, int cd_classe, String genero, String gravida, int idade, int cd_gravidade) {
        super();
        this.cd_pessoa = cd_pessoa;
        this.cpf = cpf;
        this.cd_estado = cd_estado;
        this.cd_doenca = cd_doenca;
        this.cd_raca = cd_raca;
        this.cd_classe = cd_classe;
        this.genero = genero;
        this.gravida = gravida;
        this.idade = idade;
    }

    public Pessoa() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCd_estado() {
        return cd_estado;
    }

    public void setCd_estado(int cd_estado) {
        this.cd_estado = cd_estado;
    }

    public int getCd_doenca() {
        return cd_doenca;
    }

    public void setCd_doenca(int cd_doenca) {
        this.cd_doenca = cd_doenca;
    }

    public int getCd_raca() {
        return cd_raca;
    }

    public void setCd_raca(int cd_raca) {
        this.cd_raca = cd_raca;
    }

    public String getGenero() {
        return genero;
    }

    public int getCd_pessoa() {
        return cd_pessoa;
    }

    public void setCd_pessoa(int cd_pessoa) {
        this.cd_pessoa = cd_pessoa;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGravida() {
        return gravida;
    }

    public void setGravida(String gravida) {
        this.gravida = gravida;
    }

    public int getCd_classe() {
        return cd_classe;
    }

    public void setCd_classe(int cd_classe) {
        this.cd_classe = cd_classe;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCd_gravidade() {
        return cd_gravidade;
    }

    public void setCd_gravidade(int cd_gravidade) {
        this.cd_gravidade = cd_gravidade;
    }
}
