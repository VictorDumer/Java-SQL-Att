package Data;

import java.sql.*;
import java.util.*;

import CriandoItem.*;

public class CategoriaDAO {
    
    public boolean inserir(Categoria cat){
        String sql = "INSERT INTO categorias (nome, ativo) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cat.getNome());
            stmt.setBoolean(2, cat.getAtivo());
            stmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resposta = stmt.executeQuery(sql)) {

            while (resposta.next()) {
                Categoria cat = new Categoria(resposta.getString("nome"), resposta.getBoolean("ativo"));
                cat.setId(resposta.getInt("id"));
                lista.add(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void atualizar(Categoria cat) {
        String sql = "UPDATE categorias SET nome=?, ativo=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cat.getNome());
            stmt.setBoolean(2, cat.getAtivo());
            stmt.setInt(3, cat.getId());
            stmt.executeUpdate();
            System.out.println("Categoria atualizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM categorias WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Categoria deletada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

