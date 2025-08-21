package Telas;
import javax.swing.*;

public class Hub extends JFrame{
    private JPanel tela;
    private JButton categoria,produto;
    private boolean escolha=false;
    public  Hub(){
        super("HUB INICIAL");
        tela();
    }    
    public void tela(){
        tela = new JPanel();
        categoria = new JButton("Categoria");
        produto = new JButton("Produto");

        produto.addActionListener(e->abrirTela(true));
        categoria.addActionListener(e-> abrirTela(false));

        tela.add(produto);
        tela.add(categoria);
        this.setResizable(false);
        this.setContentPane(tela);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
    }
    public boolean getEscolha(){return escolha;};

    public boolean abrirTela(boolean escolha){
        new Screen(escolha);
        this.setVisible(false);
        return escolha;
    }
    
    
}
