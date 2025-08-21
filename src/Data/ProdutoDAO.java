package Data;

import java.sql.*;
import java.util.*;
import CriandoItem.*;


public class ProdutoDAO {


    public boolean inserir(Produto p) {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resposta = stmt.executeQuery(sql)) {

            while (resposta.next()) {
                Produto p = new Produto(resposta.getString("nome"), resposta.getDouble("preco"));
                p.setId(resposta.getInt("id"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            

        }
        return lista;
    }
    public boolean atualizar(Produto p) {
        String sql = "UPDATE produtos SET nome=?, preco=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
            System.out.println("Produto atualizado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM produtos WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

}
