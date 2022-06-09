package br.com.fiap.dao;

import br.com.fiap.bean.Usuario;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleUsuarioDAO implements UsuarioDAO {

    private Connection conexao;

    public void insert(Usuario usuario) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_USUARIO(ID_USUARIO, NM_USER, EMAIL_USER, ALTURA_USER, IDADE_USER, ID_PROFESSOR, ID_PROFESSOR) VALUES (SQ_USUARIO.NEXTVAL, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setFloat(3, usuario.getAltura());
            stmt.setInt(4, usuario.getIdade());

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

    public List<Usuario> getAll() {
        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_USUARIO");
            rs = stmt.executeQuery();
            //Percorre todos os registos
            while (rs.next()) {
                int codigo = rs.getInt("ID_USUARIO");
                String nome = rs.getString("NM_USER");
                String email = rs.getString("EMAIL_USER");
                float altura = rs.getFloat("ALTURA_USER");
                int idade = rs.getInt("IDADE_USER");
                // Cria um objeto Usuario com as inf encontrada
                Usuario usuario = new Usuario(codigo, nome, email, altura, idade);
                lista.add(usuario);
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