package br.com.fiap.dao;
import br.com.fiap.bean.Doenca;
import java.util.List;

public interface DoencaDAO {

    public void insert(Doenca doenca);

    public List<Doenca> getAll();
}