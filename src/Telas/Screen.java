package Telas;

import javax.swing.*;

import CriandoItem.Produto;
import Data.ProdutoDAO;

public class Screen extends JFrame {
    private JPanel tela;
    private JButton inserir, atualizar, deletar, listar;
    private JLabel credits;
    boolean escolha;
    private JTextField envNome,envPreco;
    public Screen(boolean escolha) {
        this.escolha = escolha;
        setTitle(escolha ? "Produto | Tela de relacionamento C-R-U-D" : "Categoria | Tela de relacionamento C-R-U-D");
        janela();
    }

    public void janela() {
        tela = new JPanel();
        tela.setLayout(null);

        inserir = new JButton("Inserir");
        inserir.setBounds(100, 150, 140, 50);
        listar = new JButton("Listar");
        listar.setBounds(260, 150, 140, 50);
        atualizar = new JButton("Atualizar");
        atualizar.setBounds(100, 230, 140, 50);
        deletar = new JButton("Remover");
        deletar.setBounds(260, 230, 140, 50);
        credits = new JLabel("Feito por Victor Dumer, 2DS AMS");
        credits.setBounds(260, 400, 140, 50);

       
        inserir.addActionListener(e -> new Inserir(escolha));

        listar.addActionListener(e -> new Listar(escolha));

        atualizar.addActionListener(e -> new Atualizar(escolha));

        deletar.addActionListener(e -> new Deletar(escolha));



        tela.add(inserir);
        tela.add(listar);
        tela.add(atualizar);
        tela.add(deletar);
        tela.add(credits);

        this.setResizable(false);
        this.setContentPane(tela);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void Enviar() {
    String nome = envNome.getText(); 
   
    try {
       
        double preco = Double.parseDouble(envPreco.getText()); 
        
        Produto p = new Produto(nome, preco);
        ProdutoDAO dao = new ProdutoDAO();
        if(dao.inserir(p)){
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
            
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }   
    } catch ( Exception e ) {
        JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número!", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        
    }
}
    
}
