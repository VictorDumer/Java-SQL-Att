package Telas;

import CriandoItem.Produto;
import Data.ProdutoDAO;

import javax.swing.*;


public class Inserir extends JFrame {


    private JPanel tela_pergunta,tela;
    private JLabel nome, preco,pergunta;
    private JTextField envNome,envPreco;
    private JButton enviar, produto, categoria;
    public Inserir(){
         super("Inserir Produto");


        pergunta();
    }
    public void pergunta(){
        tela_pergunta = new JPanel();
        pergunta = new JLabel("Você vai adicionar um:");
        produto = new JButton("Produto");
        categoria= new JButton("Categoria");


        produto.addActionListener(e-> prod());
        
        tela_pergunta.setVisible(true);
    }


    public void prod(){
        tela = new JPanel();
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nome = new JLabel("Digite o nome do produto:");

        envNome= new JTextField(15);

        preco = new JLabel("Digite o preço do produto:");

        envPreco = new JTextField(15);

        enviar = new JButton("Enviar");


        enviar.addActionListener(e-> Enviar());
        tela.add(nome);
        tela.add(envNome);
        tela.add(preco);
        tela.add(envPreco);
        tela.add(enviar);
        this.add(tela);

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
