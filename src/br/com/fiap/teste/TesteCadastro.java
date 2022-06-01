package br.com.fiap.teste;

import br.com.fiap.bean.Estado;
import br.com.fiap.bean.Doenca;
import br.com.fiap.dao.OracleClasseSocialDAO;
import br.com.fiap.dao.OracleEstadoDAO;

import java.util.Calendar;

public class TesteCadastro {

    public static void main(String[] args) {
        //Instancia DAO
        OracleEstadoDAO dao = new OracleEstadoDAO();

        //instancia nutricionista
        Doenca professor = new Doenca();
        professor.setNome("Victoria");
        professor.setCref(2132);

        //cadastrar no banco
        dao.insert(professor);

        System.out.println("Cadastrado!");
    }

}
