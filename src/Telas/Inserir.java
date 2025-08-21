package Telas;

import CriandoItem.Categoria;
import CriandoItem.Produto;
import Data.CategoriaDAO;
import Data.ProdutoDAO;
import javax.swing.*;


public class Inserir extends JFrame {
    private JPanel tela;
    private JLabel nome, preco;
    private JTextField envNome,envPreco;
    private JButton enviar;
    private boolean escolha;
    
    public Inserir(boolean escolha){
        this.escolha=escolha;
        String titulo = escolha ? "Inserir Produto" : "Inserir Categoria";
        setTitle(titulo);
        prod();
    }
    
    public void prod(){
        tela = new JPanel();
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (escolha) {
            
            nome = new JLabel("Digite o nome do produto:");
            
            preco = new JLabel("Digite o preço do produto:");
            
        }else{
             nome = new JLabel("Digite o nome da Categoria:");
            
            preco = new JLabel("Digite se a categoria esta ativa:");
            
        }

            envNome= new JTextField(15);
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
   if(escolha){
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
    }else{
        boolean ativo = Boolean.parseBoolean(envPreco.getText());
        Categoria c = new Categoria(nome, ativo);
        CategoriaDAO dao = new CategoriaDAO();
        if(dao.inserir(c)){
               JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }  
    }
    }
    
}
