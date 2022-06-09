package br.com.fiap.dao;

import br.com.fiap.bean.Raca;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleRacaDAO implements RacaDAO {

    private Connection conexao;

    public void insert(Raca raca) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_RACA(CD_RACA, NM_USER) VALUES (SQ_USUARIO.NEXTVAL, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, raca.getCd_raca());
            stmt.setString(2, raca.getNm_raca());

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

    public List<Raca> getAll() {
        List<Raca> lista = new ArrayList<Raca>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_RACA");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cd_raca = rs.getInt("CD_RACA");
                String nm_raca = rs.getString("NM_RACA");
                Raca raca = new Raca(cd_raca, nm_raca);
                lista.add(raca);
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