package br.com.fiap.dao;

import br.com.fiap.bean.Raca;

import java.util.List;

public interface RacaDAO {
    public void insert(Raca usuario);

    public List<Raca> getAll();
}
