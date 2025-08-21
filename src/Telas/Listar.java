package Telas;

import javax.swing.*;

import CriandoItem.Categoria;
import CriandoItem.Produto;
import Data.CategoriaDAO;
import Data.ProdutoDAO;

public class Listar extends JFrame {

    private JPanel tela;
    private JTextArea tabela;
    private JButton listar;
    private boolean escolha;

    public Listar(boolean escolha) {
        this.escolha = escolha;
        String titulo = escolha ? "Listando Produto" : "Listando Categoria";
        setTitle(titulo);
        prod();
    }

    public void prod() {
        tela = new JPanel();
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabela = new JTextArea(20, 40);
        tabela.setEditable(false); 
        JScrollPane scroll = new JScrollPane(tabela);

        listar = new JButton("Listar");
        listar.addActionListener(e -> Listar());

        tela.add(scroll);
        tela.add(listar);

        this.add(tela);
        this.setVisible(true);
    }

   public void Listar() {
    try {
        StringBuilder sb = new StringBuilder();

        if (escolha) {
            ProdutoDAO dao = new ProdutoDAO();
            java.util.List<Produto> produtos = dao.listar();

            sb.append("ID\tNome\t\tPreço\n");
            sb.append("----------------------------------\n");
            for (Produto p : produtos) {
                sb.append(p.getId()).append("\t")
                  .append(p.getNome()).append("\t\t")
                  .append("R$ ").append(String.format("%.2f", p.getPreco()))
                  .append("\n");
            }
        } else {
            CategoriaDAO dao = new CategoriaDAO();
            java.util.List<Categoria> categorias = dao.listar();

            sb.append("ID\tNome\t\tAtivo\n");
            sb.append("----------------------------------\n");
            for (Categoria c : categorias) {
                sb.append(c.getId()).append("\t")
                  .append(c.getNome()).append("\t\t")
                  .append(c.getAtivo() ? "Sim" : "Não")
                  .append("\n");
            }
        }

        tabela.setText(sb.toString());

    } catch (Exception e) {
        if (e.getMessage().toLowerCase().contains("conexão") || e.getMessage().toLowerCase().contains("connection")) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar no banco de dados",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao listar registros",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
        System.out.println(e.getMessage());
    }
}



}
