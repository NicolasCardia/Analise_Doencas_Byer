package br.com.fiap.dao;

import br.com.fiap.bean.Estado;
import br.com.fiap.jdbc.EmpresaDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OracleEstadoDAO implements EstadoDAO {

    private Connection conexao;

    public void insert(Estado estado) {
        PreparedStatement stmt = null;

        try {
            conexao = EmpresaDBManager.obterConexao();
            String sql = "INSERT INTO TB_ESTADO(CD_ESTADO, NM_ESTADO, CODIGO_REGIAO, REGIAO_CD_REGIAO) VALUES (SQ_ESTADO.NEXTVAL, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, estado.getCd_estado());
            stmt.setString(2, estado.getNm_estado());
            stmt.setInt(3, estado.getCodigo_regiao());
            stmt.setInt(4, estado.getRegiao_cd_regiao());

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

    public List<Estado> getAll() {
        List<Estado> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = EmpresaDBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM TB_ESTADO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int cd_estado = rs.getInt("CD_ESTADO");
                String nm_estado = rs.getString("NM_ESTADO");
                int codigo_regiao = rs.getInt("CODIGO_REGIAO");
                int Regiao_cd_regiao = rs.getInt("REGIAO_CD_REGIAO");

                Estado newEstado = new Estado(cd_estado, nm_estado, codigo_regiao, Regiao_cd_regiao);
                lista.add(newEstado);
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
