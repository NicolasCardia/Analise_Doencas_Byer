package br.com.fiap.dao;

import br.com.fiap.bean.Pessoa;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OraclePessoaDAO implements PessoaDAO {

    private Connection conexao;

    public void insert(Pessoa pessoa) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO PESSOA(CD_PESSOA, CPF, CD_ESTADO, CD_DOENCA, CD_RACA, GENERO, GRAVIDA, CD_CLASSE, CD_GRAVIDADE, IDADE) VALUES (SQ_PESSOA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoa.getCpf());
            stmt.setInt(2, pessoa.getCd_estado());
            stmt.setInt(3, pessoa.getCd_doenca());
            stmt.setInt(4, pessoa.getCd_raca());
            stmt.setString(5, pessoa.getGenero());
            stmt.setBoolean(6, pessoa.getGravida());
            stmt.setInt(7, pessoa.getCd_classe());
            stmt.setInt(8, pessoa.getCd_gravidade());
            stmt.setInt(9, pessoa.getIdade());

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

    public List<Pessoa> getAll() {
        // Cria uma lista de colaboradores
        List<Pessoa> lista = new ArrayList<Pessoa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM PESSOA");
            rs = stmt.executeQuery();

            //Percorre todos os registos
            while (rs.next()) {
                int cd_pessoa = rs.getInt("CD_PESSOA");
                String cpf = rs.getString("CPF");
                int cd_estado = rs.getInt("CD_ESTADO");
                int cd_doenca = rs.getInt("CD_DOENCA");
                int cd_raca = rs.getInt("CD_RACA");
                String genero = rs.getString("GENERO");
                Boolean gravida = rs.getBoolean("GRAVIDA");
                int cd_classe = rs.getInt("CD_CLASSE");
                int cd_gravidade = rs.getInt("CD_GRAVIDADE");
                int idade = rs.getInt("IDADE");
                // Cria um objeto Exercicio com as inf encontrada
                Pessoa novaPessoa = new Pessoa(cd_pessoa,cpf, cd_estado, cd_doenca, cd_raca, cd_classe, genero, gravida, idade, cd_gravidade);
                lista.add(novaPessoa);
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