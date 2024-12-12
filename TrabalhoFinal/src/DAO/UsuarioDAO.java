package DAO;

import conexao.Conexao;
import beans.Usuario;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Conexao conexao;
    private Connection conn;

    public UsuarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nome, matricula, contato) VALUES (?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setString(3, usuario.getContato());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuario: " + ex.getMessage());
        }

    }

    public void editar(Usuario usuario) {
        try {
            String sql = "UPDATE Usuario SET nome=?, matricula=?, contato=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setString(3, usuario.getContato());
            stmt.setInt(4, usuario.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar  usuario: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Usuario WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuario: " + ex.getMessage());
        }

    }

    public List<Usuario> getUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setMatricula(rs.getString("matricula"));
                u.setContato(rs.getString("contato"));
                listaUsuarios.add(u);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            System.out.println("Erro ai : " + ex.getMessage());
            return null;
        }
    }

    public Usuario getUsuario(int id) {
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Usuario p = new Usuario();

            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setMatricula(rs.getString("matricula"));
            p.setContato(rs.getString("contato"));
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuario:" + ex.getMessage());
            return null;
        }
    }
}
