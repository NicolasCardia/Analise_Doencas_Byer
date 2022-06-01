package br.com.fiap.dao;

import br.com.fiap.bean.Regiao;

import java.util.List;

public interface DoencaDAO {

    public void insert(Regiao peso);

    public List<Regiao> getAll();
}
