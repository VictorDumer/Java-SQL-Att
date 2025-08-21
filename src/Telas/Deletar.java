package Telas;

import javax.swing.*;

import CriandoItem.Categoria;
import CriandoItem.Produto;
import Data.CategoriaDAO;
import Data.ProdutoDAO;
public class Deletar extends JFrame{
    private JPanel tela;
    private JLabel id;
    private JTextField envId;
    private JButton deletar;
    private boolean escolha;
    
    public Deletar(boolean escolha){
        this.escolha=escolha;
        String titulo = escolha ? "Deletar Produto" : "Deletar Categoria";
        setTitle(titulo);
        prod();
        this.setVisible(true);
    }
    public void prod(){
        tela = new JPanel();
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (escolha) {
            id = new JLabel("Digite o id do produto:");

            
        }else{
            id = new JLabel("Digite o id da Categoria:");
  
        }
        envId= new JTextField(15);
           

        deletar = new JButton("Enviar");


        deletar.addActionListener(e-> Deletar());
        tela.add(id);
        tela.add(envId);
        tela.add(deletar);
        this.add(tela);

        this.setVisible(true);
    }

    public void Deletar() {
   if(escolha){
       try {
           int id = Integer.parseInt(envId.getText());

            int opcao = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
            );

            if (opcao == JOptionPane.YES_OPTION) {


           ProdutoDAO dao = new ProdutoDAO();
           boolean sucesso = dao.deletar(id);
           if (sucesso) {
               JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
               JOptionPane.showMessageDialog(null, dao.listar());
           }else{
                JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);

           }
            }else{
                JOptionPane.showMessageDialog(null, "Processo Cancelado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
           
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "ID inválido. Digite um número", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
        
    }else{
        try {

            
            int id = Integer.parseInt(envId.getText());
            
            int opcao = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza que deseja atualizar este registro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
                );
                
                if (opcao == JOptionPane.YES_OPTION) {
                    
                    CategoriaDAO dao = new CategoriaDAO();
                    boolean sucesso= dao.deletar(id);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso!");
                        JOptionPane.showMessageDialog(null, dao.listar());
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Processo Cancelado", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
            catch ( Exception e ){
                JOptionPane.showMessageDialog(null, "ID inválido. Digite um número", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
        }
    }
    }
}
