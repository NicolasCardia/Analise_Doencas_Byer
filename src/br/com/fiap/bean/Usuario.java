package br.com.fiap.bean;
import java.util.Calendar;
public class Usuario {

    private int codigo;

    private String nome;

    private String email;

    private float altura;

    private int idade;


    public Usuario(int codigo, String nome, String email, float altura, int idade) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.altura = altura;
        this.idade = idade;
    }

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}