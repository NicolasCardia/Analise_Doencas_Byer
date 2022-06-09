package br.com.fiap.dao;
import br.com.fiap.bean.ZonaDeContagio;
import java.util.List;

public interface ZonaDeContagioDAO {
    public void insert(ZonaDeContagio zonaDeContagio);

    public List<ZonaDeContagio> getAll();
}
