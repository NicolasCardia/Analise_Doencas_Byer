package br.com.fiap.dao;

import br.com.fiap.bean.Doenca;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDoencaDAO implements DoencaDAO {

    private Connection conexao;

    public void insert(Doenca doenca) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_DOENCA(CD_DOENCA, NM_DOENCA) VALUES (SQ_DOENCA.NEXTVAL, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, doenca.getCd_doenca());
            stmt.setString(2, doenca.getNm_doenca());

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

    public List<Doenca> getAll() {
        List<Doenca> lista = new ArrayList<Doenca>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_DOENCA");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int cd_doenca = rs.getInt("CD_DOENCA");
                String nm_doenca = rs.getString("NM_DOENCA");
                Doenca newDoenca = new Doenca(cd_doenca, nm_doenca);
                lista.add(newDoenca);
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