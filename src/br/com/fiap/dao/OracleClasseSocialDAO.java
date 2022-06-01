package br.com.fiap.dao;

import br.com.fiap.bean.ClasseSocial;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleClasseSocialDAO implements ClasseSocialDAO {

    private Connection conexao;

    public void insert(ClasseSocial classeSocial) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_CLASSESOCIAL(CD_CLASSE, NM_CLASSE) VALUES (SQ_CLASSESOCIAL.NEXTVAL, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, classeSocial.getCd_classe());
            stmt.setString(2, classeSocial.getNm_classe());

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

    public List<ClasseSocial> getAll() {
        // Cria uma lista de colaboradores
        List<ClasseSocial> lista = new ArrayList<ClasseSocial>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_CLASSESOCIAL");
            rs = stmt.executeQuery();

            //Percorre todos os registos
            while (rs.next()) {
                int cd_classe = rs.getInt("CD_CLASSE");
                String nm_classe = rs.getString("NM_CLASSE");
                // Cria um objeto Nutricionista com as inf encontrada
                ClasseSocial novaClasseSocial = new ClasseSocial(cd_classe, nm_classe);
                lista.add(novaClasseSocial);
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

    public Estado buscarPorId(int codigoBusca) {
        Estado nutricionista = null;
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
                nutricionista = new Estado(codigo, nome, crn);
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

    public void atualizar(Estado colaborador) {
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

    @Override
    public void cadastrar(ClasseSocial ClasseSocial) {
        // TODO Auto-generated method stub
        
    }
}

