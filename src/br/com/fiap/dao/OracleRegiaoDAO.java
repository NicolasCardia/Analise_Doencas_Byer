package br.com.fiap.dao;

import br.com.fiap.bean.Regiao;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleRegiaoDAO implements RegiaoDAO {

    private Connection conexao;

    public void insert(Regiao regiao) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_REGIAO(CD_REGIAO, NM_REGIAO) VALUES (SQ_REGIAO.NEXTVAL, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, regiao.getCd_regiao());
            stmt.setString(2, regiao.getNm_regiao());
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

    public List<Regiao> getAll() {
        List<Regiao> lista = new ArrayList<Regiao>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_REGIAO");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cd_regiao = rs.getInt("CD_REGIAO");
                String nm_regiao = rs.getString("NM_REGIAO");
                Regiao newRegiao = new Regiao(cd_regiao, nm_regiao);
                lista.add(newRegiao);
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