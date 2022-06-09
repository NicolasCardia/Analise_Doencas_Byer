package br.com.fiap.dao;

import br.com.fiap.bean.ClasseSocial;

import java.util.List;

public interface ClasseSocialDAO {

    public void insert(ClasseSocial classeSocial);

    public List<ClasseSocial> getAll();

}
