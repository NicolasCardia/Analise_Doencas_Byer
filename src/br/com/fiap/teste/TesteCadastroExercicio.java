package br.com.fiap.teste;

import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.OraclePessoaDAO;

import java.util.Scanner;


import java.util.Calendar;

public class TesteCadastroExercicio {

    public static void main(String[] args) {
        //Instancia DAO
        OraclePessoaDAO dao = new OraclePessoaDAO();
        Calendar c = Calendar.getInstance();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entre com ano, mes e dia");
        int ano = myObj.nextInt();
        int mes = myObj.nextInt();
        int dia = myObj.nextInt();
        c.set(ano,  mes-1, dia);

        //instancia nova
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Bolm dia");
        pessoa.setClasse("loco");
        pessoa.setCodigo(4);
        pessoa.setData(c);


        //cadastrar no banco
        dao.insert(pessoa);

        System.out.println("Cadastrado!");
    }

}
