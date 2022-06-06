package br.com.fiap.dao;

import br.com.fiap.bean.ZonaDeContagio;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OracleZonaDeContagioDAO implements ZonaDeContagioDAO {

    private Connection conexao;

    public void insert(ZonaDeContagio zonaDeContagio) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            Date data = new Date(zonaDeContagio.getDt_contagio().getTime());
            String sql = "INSERT INTO TB_ZONACONTAGIO(CD_ZONA, AREA_CONTAGIO, DT_CONTAGIO) VALUES (SQ_ESTADO.NEXTVAL, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, zonaDeContagio.getCd_zona());
            stmt.setString(2, zonaDeContagio.getArea_contagio());
            stmt.setDate(3, data);
            stmt.setDate(3, zonaDeContagio.getDt_contagio());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ZonaDeContagio> getAll() {
        List<ZonaDeContagio> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_ZONACONTAGIO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int cd_zona = rs.getInt("CD_ZONA");
                String area_contagio = rs.getString("AREA_CONTAGIO");
                Date dt_contagio = rs.getDate("DT_CONTAGIO");

                ZonaDeContagio newZonaDeContagio = new ZonaDeContagio(cd_zona, area_contagio, dt_contagio);
                lista.add(newZonaDeContagio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
