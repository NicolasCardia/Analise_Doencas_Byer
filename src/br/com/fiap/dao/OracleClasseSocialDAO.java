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
}

