package br.com.fiap.teste;

import br.com.fiap.dao.OracleNutricionistaDAO;
import br.com.fiap.dao.OracleProfessorDAO;

public class TesteRemocao {

    public static void main(String[] args) {
        OracleProfessorDAO dao = new OracleProfessorDAO();
        // Remove o colaborador pelo cd
        dao.remover(3);
    }

}
