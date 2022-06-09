package br.com.fiap.dao;

import br.com.fiap.bean.Peso;

import java.util.List;

public interface PesoDAO {

    public void insert(Peso peso);

    public List<Peso> getAll();
}
