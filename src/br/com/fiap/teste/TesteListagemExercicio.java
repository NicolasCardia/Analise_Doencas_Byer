package br.com.fiap.teste;

import br.com.fiap.bean.Pessoa;

import br.com.fiap.dao.OraclePessoaDAO;


import java.util.List;

public class TesteListagemExercicio {

    public static void main(String[] args) {

        OraclePessoaDAO dao = new OraclePessoaDAO();

        List<Pessoa> lista = dao.getAll();
        for (Pessoa item : lista) {
            System.out.println(item.getCodigo() + " " + item.getNome() + " " + item.getData().getTime() + " " + item.getClasse());
        }
    }

}
