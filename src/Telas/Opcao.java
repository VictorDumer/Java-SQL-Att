package Telas;
import javax.swing.*;
public class Opcao  extends JFrame{
    private int escolha;
    private JPanel tela;
    private JButton produto,categoria;
    public Opcao(){
        super("a");
        perg();
    }
    public void perg(){
        tela = new JPanel();

        produto = new JButton("CRUD Produto");
        categoria = new JButton("CRUD Categoria");


        produto.addActionListener(e -> new Screen());

        categoria.addActionListener(e-> new Screen());
        
        tela.setVisible(true);
        escolha=1;
    }
    public int getNum(){return escolha;};
}
