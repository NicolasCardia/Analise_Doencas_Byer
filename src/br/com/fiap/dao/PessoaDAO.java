package br.com.fiap.dao;

import br.com.fiap.bean.Pessoa;

import java.util.List;

public interface PessoaDAO {

    public void insert(Pessoa pessoa);

    public List<Pessoa> getAll();

}