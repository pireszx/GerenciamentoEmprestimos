package DAO;

import beans.Emprestimo;
import beans.Historico;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

    private Conexao conexao;
    private Connection conn;

    public HistoricoDAO(Conexao conexao, Connection connection) {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<Historico> getHistoricos() {
        List<Historico> listaHistoricos = new ArrayList<>();
        String sql = "SELECT * FROM Historico";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Historico h = new Historico();
                EmprestimoDAO eDAO = new EmprestimoDAO();

                h.setId_historico(rs.getInt("id_historico"));
                Emprestimo e = eDAO.getEmprestimo(rs.getString("id_emprestimo"));
                h.setEstado(rs.getString("estado"));
                h.setData_acao(rs.getString("data_acao"));

                listaHistoricos.add(h);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar históricos de empréstimo: " + ex.getMessage());
        }
        return listaHistoricos;
    }
}
