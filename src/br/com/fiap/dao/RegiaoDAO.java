package br.com.fiap.dao;
import br.com.fiap.bean.Regiao;
import java.util.List;

public interface RegiaoDAO {
    public void insert(Regiao regiao);

    public List<Regiao> getAll();
}
