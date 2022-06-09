package br.com.fiap.dao;

import br.com.fiap.bean.Nutricionista;

import java.util.List;

public interface NutricionistaDAO {

    public void cadastrar(Nutricionista nutricionista);

    public List<Nutricionista> listar();

}
