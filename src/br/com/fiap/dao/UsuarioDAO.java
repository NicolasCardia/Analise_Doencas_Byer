package br.com.fiap.dao;

import br.com.fiap.bean.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public void insert(Usuario usuario);

    public List<Usuario> getAll();
}
