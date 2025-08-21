package Telas;

import javax.swing.*;

import CriandoItem.Categoria;
import CriandoItem.Produto;
import Data.CategoriaDAO;
import Data.ProdutoDAO;
public class Atualizar extends JFrame{
    private JPanel tela;
    private JLabel nome, preco, id;
    private JTextField envNome,envPreco,envId;
    private JButton atualizar;
    private boolean escolha;
    
    public Atualizar(boolean escolha){
        this.escolha=escolha;
        String titulo = escolha ? "Atualizar Produto" : "Atualizar Categoria";
        setTitle(titulo);
        prod();
    }
    public void prod(){
        tela = new JPanel();
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (escolha) {
            id = new JLabel("Digite o id do produto:");

            nome = new JLabel("Digite o nome do produto:");
            
            preco = new JLabel("Digite o preço do produto:");
            
        }else{
            id = new JLabel("Digite o id da Categoria:");

             nome = new JLabel("Digite o nome da Categoria:");
            
            preco = new JLabel("Digite se a categoria esta ativa:");
            
        }
            envId= new JTextField(15);
            envNome= new JTextField(15);
            envPreco = new JTextField(15);

        atualizar = new JButton("Atualizar");


        atualizar.addActionListener(e-> Listar());
        tela.add(id);
        tela.add(envId);
        tela.add(nome);
        tela.add(envNome);
        tela.add(preco);
        tela.add(envPreco);
        tela.add(atualizar);
        this.add(tela);

        this.setVisible(true);
    }

    public void Listar() {
    String nome = envNome.getText(); 
   if(escolha){
       try {
           double preco = Double.parseDouble(envPreco.getText()); 
           int id = Integer.parseInt(envId.getText());

           Produto p = new Produto(nome, preco,id);
           ProdutoDAO dao = new ProdutoDAO();
           boolean sucesso = dao.atualizar(p);
           if(sucesso){
               JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
               
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }   
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            
        }
    }else{
           int id = Integer.parseInt(envId.getText());
        boolean ativo = Boolean.parseBoolean(envPreco.getText());

        Categoria c = new Categoria(nome, ativo,id);
        CategoriaDAO dao = new CategoriaDAO();
        boolean sucesso= dao.atualizar(c);
        if(sucesso){
               JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso!");
               JOptionPane.showMessageDialog(null, dao.listar());
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }  
    }
    }
}
