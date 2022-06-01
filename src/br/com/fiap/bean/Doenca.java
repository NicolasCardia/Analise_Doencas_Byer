package br.com.fiap.bean;

public class Doenca {

    private int codigo;

    private String nome;

    private int cref;


    public Doenca(int codigo, String nome, int cref) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.cref = cref;
    }

    public Doenca() {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCref() {
        return cref;
    }

    public void setCref(int cref) {
        this.cref = cref;
    }
}
