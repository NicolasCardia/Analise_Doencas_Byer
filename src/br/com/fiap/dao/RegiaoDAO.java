package br.com.fiap.dao;

import br.com.fiap.bean.Regiao;

import java.util.List;

public interface RegiaoDAO {
    public void insert(Regiao usuario);

    public List<Regiao> getAll();
}
