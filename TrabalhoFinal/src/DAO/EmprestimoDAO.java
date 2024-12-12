package DAO;

import conexao.Conexao;
import beans.Emprestimo;
import beans.Item;
import beans.Usuario;
import beans.View_HistoricoEmprestimo;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmprestimoDAO {

    private Conexao conexao;
    private Connection conn;

    public EmprestimoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Emprestimo emprestimo) {
        String sql = "INSERT INTO Emprestimos (id_item, id_usuario, estado) VALUES (?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getId_item().getId());
            stmt.setInt(2, emprestimo.getId_usuario().getId());
            stmt.setString(3, emprestimo.getEstado());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuario: " + ex.getMessage());
        }

    }

    public void editar(Emprestimo emprestimo) {
        try {
            String sql = "UPDATE emprestimo SET id_item=?, id_usuario=?, date_emprestimo=?, date_vencimento=?, estado=? , WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getId_item().getId());
            stmt.setInt(2, emprestimo.getId_usuario().getId());
            stmt.setString(3, emprestimo.getData_emprestimo());
            stmt.setString(4, emprestimo.getData_vencimento());
            stmt.setString(5, emprestimo.getEstado());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar emprestimo: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Emprestimo WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir emprestimo: " + ex.getMessage());
        }

    }

    public List<Emprestimo> getEmprestimos() {
        String sql = "SELECT * FROM Emprestimo";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Emprestimo> listaEmprestimos = new ArrayList();
            while (rs.next()) {
                Emprestimo e = new Emprestimo();

                ItemDAO iDAO = new ItemDAO();
                UsuarioDAO uDAO = new UsuarioDAO();

                e.setId(rs.getInt("id"));
                Item i = iDAO.getItem(rs.getInt("id_item"));
                Usuario u = uDAO.getUsuario(rs.getInt("id_usuario"));
                e.setData_emprestimo(rs.getString("data_emprestimo"));
                e.setData_vencimento(rs.getString("data_vencimento"));
                e.setEstado(rs.getString("estado"));

                listaEmprestimos.add(e);
            }
            return listaEmprestimos;
        } catch (SQLException ex) {
            System.out.println("Erro ai : " + ex.getMessage());
            return null;
        }
    }
    
    public Emprestimo getEmprestimo(String matricula) {
        String sql = "SELECT * FROM Emprestimo e "
                + "JOIN Usuario u ON e.id_usuario = u.id "
                + "WHERE u.matricula = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            Emprestimo e = new Emprestimo();
            ItemDAO iDAO = new ItemDAO();
            UsuarioDAO uDAO = new UsuarioDAO();

            if (rs.first()) {
                e.setId(rs.getInt("id"));
                Item i = iDAO.getItem(rs.getInt("id_item"));
                Usuario u = uDAO.getUsuario(rs.getInt("id_usuario"));
                e.setData_emprestimo(rs.getString("data_emprestimo"));
                e.setData_vencimento(rs.getString("data_vencimento"));
                e.setEstado(rs.getString("estado"));
                return e;
            } else {
                System.out.println("Empréstimo não encontrado para a matrícula: " + matricula);
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar empréstimo: " + ex.getMessage());
            return null;
        }
    }

    public List<Emprestimo> procedureRelatorioItensMaisEmprestados() {
        String sql = "{CALL RelatorioItensMaisEmprestados()}";
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();

            List<Emprestimo> listaRelatorio = new ArrayList<>();
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setEstado(String.valueOf(rs.getInt("QuantidadeEmprestimos")));

                Item item = new Item();
                item.setNome(rs.getString("Item"));
                emprestimo.setId_item(item);

                listaRelatorio.add(emprestimo);
            }
            return listaRelatorio;
        } catch (SQLException ex) {
            System.out.println("Erro ao chamar o relatório de itens mais emprestados: " + ex.getMessage());
            return null;
        }
    }

    public List<Map<String, Object>> procedureItensAtrasados() {
        String sql = "{CALL RelatorioItensAtrasados()}";

        try {
            CallableStatement stmt = conn.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();

            List<Map<String, Object>> itensAtrasados = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> item = new HashMap<>();
                item.put("Responsavel", rs.getString("Responsavel"));
                item.put("Item", rs.getString("Item"));
                item.put("Emprestimo", rs.getTimestamp("Emprestimo"));
                item.put("Vencimento", rs.getTimestamp("Vencimento"));
                item.put("DiasAtraso", rs.getInt("DiasAtraso"));

                itensAtrasados.add(item);
            }
            return itensAtrasados;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar itens atrasados: " + ex.getMessage());
            return null;
        }
    }

    public List<View_HistoricoEmprestimo> vw_HistoricoEmprestimos(String filtroMatricula, String filtroNomeItem) throws SQLException {
        List<View_HistoricoEmprestimo> listaHistorico = new ArrayList<>();

        String sql = "SELECT e.*, i.nome AS nome_item, u.matricula, u.nome AS nome_usuario "
                + "FROM Emprestimos e "
                + "JOIN Itens i ON e.id_item = i.id "
                + "JOIN Usuarios u ON e.id_usuario = u.id "
                + "WHERE 1 = 1 ";

        if (filtroMatricula != null && !filtroMatricula.isEmpty()) {
            sql += "AND u.matricula = ? ";
        }

        if (filtroNomeItem != null && !filtroNomeItem.isEmpty()) {
            sql += "AND i.nome = ? ";
        }

        PreparedStatement stmt = conn.prepareStatement(sql);

        int paramIndex = 1;
        if (filtroMatricula != null && !filtroMatricula.isEmpty()) {
            stmt.setString(paramIndex++, filtroMatricula);
        }

        if (filtroNomeItem != null && !filtroNomeItem.isEmpty()) {
            stmt.setString(paramIndex++, filtroNomeItem);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            View_HistoricoEmprestimo historico = new View_HistoricoEmprestimo();
            historico.setResponsavel(rs.getString("nome_usuario"));
            historico.setMatriculaUsuario(rs.getString("matricula"));
            historico.setItem(rs.getString("nome_item"));
            historico.setStatus(rs.getString("estado"));
            historico.setDataAtualizacao(rs.getTimestamp("data_emprestimo"));
            listaHistorico.add(historico);
        }

        return listaHistorico;
    }
}
    
