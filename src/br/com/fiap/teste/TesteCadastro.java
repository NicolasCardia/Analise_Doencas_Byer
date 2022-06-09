package br.com.fiap.teste;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.OraclePessoaDAO;


public class TesteCadastro {

    public static void main(String[] args) {
        //Instancia DAO
        OraclePessoaDAO dao = new OraclePessoaDAO();

        //instancia Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("12345678912");
        pessoa.setCd_estado(1);
        pessoa.setCd_doenca(1);
        pessoa.setCd_raca(1);
        pessoa.setCd_classe(1);
        pessoa.setGenero("M");
        pessoa.setGravida(Boolean.FALSE);
        pessoa.setIdade(34);
        pessoa.setCd_gravidade(1);

        //cadastrar no banco
        dao.insert(pessoa);

        System.out.println("Cadastrado!");
    }

}
