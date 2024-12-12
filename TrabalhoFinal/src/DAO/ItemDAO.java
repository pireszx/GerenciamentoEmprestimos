package DAO;

import beans.Item;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private Conexao conexao;
    private Connection conn;

    public ItemDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Item item) {
        String sql = "INSERT INTO Itens (nome, categoria) VALUES (?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar item: " + ex.getMessage());
        }
    }

    public void editar(Item item) {
        String sql = "UPDATE Itens SET nome = ?, categoria = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setInt(3, item.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar item: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Itens WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir item: " + ex.getMessage());
        }
    }

    public List<Item> getItens() {
        String sql = "SELECT * FROM Itens";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Item> listaItem = new ArrayList<>();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setCategoria(rs.getString("categoria"));
                listaItem.add(item);
            }
            return listaItem;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar os itens: " + ex.getMessage());
            return null;
        }
    }

    public Item getItem(int id) {
        String sql = "SELECT * FROM Itens WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setCategoria(rs.getString("categoria"));
                return item;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar o item: " + ex.getMessage());
            return null;
        }
    }

}
