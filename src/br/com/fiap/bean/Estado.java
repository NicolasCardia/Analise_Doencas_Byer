package br.com.fiap.bean;
import java.util.Calendar;
public class Estado {

    private int codigo;

    private String nome;

    //private String email;

    private int crn;

    //private Calendar dataContratacao;

    /*public Nutricionista(int codigo, String nome, String email, double salario, Calendar dataContratacao) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }*/

    public Estado(int codigo, String nome, int crn) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.crn = crn;
    }

    public Estado() {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
