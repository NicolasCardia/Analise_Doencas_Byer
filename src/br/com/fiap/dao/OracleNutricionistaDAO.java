package br.com.fiap.dao;

import br.com.fiap.bean.Nutricionista;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleNutricionistaDAO implements NutricionistaDAO {

    private Connection conexao;

    public void cadastrar(Nutricionista nutricionista) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_NUTRICIONISTA(ID_NUTRICIONISTA, NM_NUTRICIONISTA, CRN_NUTRICIONISTA) VALUES (SQ_NUTRI.NEXTVAL, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nutricionista.getNome());
            stmt.setInt(2, nutricionista.getCrn());
            //stmt.setDouble(3, nutricionista.getSalario());
            //java.sql.Date data = new java.sql.Date(nutricionista.getDataContratacao().getTimeInMillis());
            //stmt.setDate(4, data);

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

    public List<Nutricionista> listar() {
        // Cria uma lista de colaboradores
        List<Nutricionista> lista = new ArrayList<Nutricionista>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_NUTRICIONISTA");
            rs = stmt.executeQuery();

            //Percorre todos os registos
            while (rs.next()) {
                int codigo = rs.getInt("ID_NUTRICIONISTA");
                String nome = rs.getString("NM_NUTRICIONISTA");
                int crn = rs.getInt("CRN_NUTRICIONISTA");
                // Cria um objeto Nutricionista com as inf encontrada
                Nutricionista colaborador = new Nutricionista(codigo, nome, crn);
                lista.add(colaborador);
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
            String sql = "DELETE FROM TB_NUTRICIONISTA WHERE ID_NUTRICIONISTA = ?";
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

    public Nutricionista buscarPorId(int codigoBusca) {
        Nutricionista nutricionista = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_NUTRICIONISTA WHERE ID_NUTRICIONISTA = ?");
            stmt.setInt(1, codigoBusca);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigo = rs.getInt("CD_COLABORADOR");
                String nome = rs.getString("NM_NUTRICIONISTA");
                int crn = rs.getInt("CRN_NUTRICIONISTA");
                nutricionista = new Nutricionista(codigo, nome, crn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nutricionista;
    }

    public void atualizar(Nutricionista colaborador) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "UPDATE TB_NUTRICIONISTA SET NM_NUTRICIONISTA = ?, CRN_NUTRICIONISTA = ? WHERE CD_COLABORADOR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, colaborador.getNome());
            stmt.setInt(2, colaborador.getCrn());
            stmt.setInt(3, colaborador.getCodigo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

