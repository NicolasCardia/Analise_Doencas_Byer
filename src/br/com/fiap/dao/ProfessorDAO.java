package br.com.fiap.dao;

import br.com.fiap.bean.Nutricionista;
import br.com.fiap.bean.Professor;

import java.util.List;

public interface ProfessorDAO {

    public void insert(Professor professor);

    public List<Professor> getAll();
}
