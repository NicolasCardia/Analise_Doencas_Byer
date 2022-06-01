package br.com.fiap.teste;

import br.com.fiap.dao.OracleClasseSocialDAO;
import br.com.fiap.dao.OracleEstadoDAO;

public class TesteRemocao {

    public static void main(String[] args) {
        OracleEstadoDAO dao = new OracleEstadoDAO();
        // Remove o colaborador pelo cd
        dao.remover(3);
    }

}
