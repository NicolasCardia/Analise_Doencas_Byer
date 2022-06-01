package br.com.fiap.dao;

import br.com.fiap.bean.Estado;
import br.com.fiap.bean.Doenca;

import java.util.List;

public interface EstadoDAO {

    public void insert(Doenca professor);

    public List<Doenca> getAll();
}
