package Telas;

import javax.swing.*;

public class Screen extends JFrame {
    private JPanel tela;
    private JButton inserir, atualizar, deletar, listar;
    private JLabel credits;

    public Screen() {
        super("Tela de relacionamento C-R-U-D");
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
        

        inserir.addActionListener(e -> new Inserir());

        listar.addActionListener(e -> new Listar());

        atualizar.addActionListener(e -> new Atualizar());

        deletar.addActionListener(e -> new Deletar());



        tela.add(inserir);
        tela.add(listar);
        tela.add(atualizar);
        tela.add(deletar);
        tela.add(credits);

        this.setResizable(false);
        this.setContentPane(tela);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Screen tela = new Screen();
    }
}
