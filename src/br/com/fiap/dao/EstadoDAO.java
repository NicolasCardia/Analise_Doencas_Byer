package br.com.fiap.dao;

import br.com.fiap.bean.Estado;

import java.util.List;

public interface EstadoDAO {

    public void insert(Estado estado);

    public List<Estado> getAll();
}
