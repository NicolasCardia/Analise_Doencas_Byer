package br.com.fiap.dao;

import br.com.fiap.bean.Doenca;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleEstadoDAO implements EstadoDAO {

    private Connection conexao;

    public void insert(Doenca professor) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_PROFESSOR(ID_PROFESSOR, NM_PROFESSOR, CREF_PROFESSOR) VALUES (SQ_PROFESSOR.NEXTVAL, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getCref());

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
        List<Doenca> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_PROFESSOR");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("ID_PROFESSOR");
                String nome = rs.getString("NM_PROFESSOR");
                int cref = rs.getInt("CREF_PROFESSOR");

                Doenca professor = new Doenca(codigo, nome, cref);
                lista.add(professor);
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

    public void remover(int codigo) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "DELETE FROM TB_PROFESSOR WHERE ID_PROFESSOR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
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
}
