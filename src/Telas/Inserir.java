package Telas;

import CriandoItem.Produto;
import Data.ProdutoDAO;

import javax.swing.*;


public class Inserir extends JFrame {


    private JPanel tela;
    private JLabel nome, preco;
    private JTextField envNome,envPreco;
    private JButton enviar;
    public Inserir(){
         super("Inserir Produto");

        prod();
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
