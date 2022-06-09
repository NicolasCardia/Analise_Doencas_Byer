package br.com.fiap.dao;

import br.com.fiap.bean.Peso;
import br.com.fiap.jdbc.EmpresaDBManager;
import oracle.sql.JAVA_STRUCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;


public class OraclePesoDAO implements PesoDAO {

    private Connection conexao;

    public void insert(Peso peso) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_EXERCICIOS(ID_PESO, DT_PESO, VL_PESO) VALUES (SQ_PESO.NEXTVAL, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            Date data = new Date(peso.getData().getTimeInMillis());
            stmt.setDate(1, data);
            stmt.setFloat(2, peso.getPeso());

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

    public List<Peso> getAll() {
        // Cria uma lista de colaboradores
        List<Peso> lista = new ArrayList<Peso>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_PESO");
            rs = stmt.executeQuery();

            //Percorre todos os registos
            while (rs.next()) {
                int codigo = rs.getInt("ID_PESO");
                java.sql.Date data_peso = rs.getDate("DT_PESO");
                Calendar dataPeso = Calendar.getInstance();
                dataPeso.setTimeInMillis(data_peso.getTime());
                float peso = rs.getFloat("VL_PESO");
                // Cria um objeto Exercicio com as inf encontrada
                Peso novoPeso = new Peso(codigo, dataPeso, peso);
                lista.add(novoPeso);
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