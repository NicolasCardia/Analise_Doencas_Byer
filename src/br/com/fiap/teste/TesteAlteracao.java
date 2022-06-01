package br.com.fiap.teste;

import br.com.fiap.bean.Estado;
import br.com.fiap.dao.OracleClasseSocialDAO;

public class TesteAlteracao {

    public static void main(String[] args) {

        OracleClasseSocialDAO dao = new OracleClasseSocialDAO();
        //Recupera o nutricionista com código 1
        Estado nutricionista = dao.buscarPorId(1);
        //Imprime os valores do nutricionista
        System.out.println(nutricionista.getCodigo() + " "
                + nutricionista.getNome() + " " + nutricionista.getCrn());
        //Altera os valores de alguns atributos do nutricionista
        nutricionista.setCrn(5647);
        nutricionista.setNome("teste@fiap.com.br");
        //Atualiza no banco de dados
        dao.atualizar(nutricionista);
    }

}