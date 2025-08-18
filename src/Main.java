import Telas.Screen;

import java.util.*;
import Data.*;
import CriandoItem.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int op = 0;
        int op2;
        Scanner sc = new Scanner(System.in);
        while(op !=4){
        System.out.println("  ___________________ HUB INICIAL ______________________ ");
        System.out.println(" |                                                      |");
        System.out.println(" | 1- Categoria | 2- Produto | 3- Tela Visual | 4- Sair | ");
        System.out.println(" |                                                      |");
        System.out.println(" |___________________ HUB INICIAL ______________________| ");

        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                CategoriaDAO cdao = new CategoriaDAO();
                System.out.println(" -------------------> Categoria <------------------------- ");
                System.out.println(" | 1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar|");
                System.out.println(" -------------------> Categoria <------------------------- ");

                op2 = sc.nextInt();
                sc.nextLine();

                switch (op2) {
                    case 1:
                        String nome;
                        boolean ativo;

                        System.out.print("Nome:");
                        nome = sc.nextLine();
                        System.out.print("Ativo (True/False): ");
                        ativo = sc.nextBoolean();
                        sc.nextLine();

                        Categoria c = new Categoria(nome, ativo);
                        cdao.inserir(c);
                        break;

                    case 2:
                        for (Categoria prod : cdao.listar()) {
                            System.out.println("Nome:" +prod.getNome() + " - Ativo:" + prod.getAtivo());
                        }
                        break;
                    case 3:
                        int id;
                        System.out.print("ID do produto para listar: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Novo Nome:");
                        nome = sc.nextLine();
                        System.out.print("Novo Ativo (True/False):  ");
                        ativo = sc.nextBoolean();
                        sc.nextLine();

                        c = new Categoria(nome, ativo);
                        c.setId(id);
                        cdao.atualizar(c);
                        break;
                    case 4:
                        System.out.print("ID da Categoria para listar: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        cdao.deletar(id);
                    default:
                        System.out.print("Opcao invalida:");
                        break;
                }

                break;
            case 2:
                ProdutoDAO pdao = new ProdutoDAO();
                System.out.println(" --------------------> Produto <-------------------- ");

                System.out.println("1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar");
                op2 = sc.nextInt();
                sc.nextLine();

                switch (op2) {
                    case 1:
                        String nome;
                        double preco;

                        System.out.print("Nome:");
                        nome = sc.nextLine();
                        System.out.print("Preco:");
                        preco = sc.nextDouble();
                        sc.nextLine();
                        Produto p = new Produto(nome, preco);
                        pdao.inserir(p);
                        break;

                    case 2:
                        for (Produto prod : pdao.listar()) {
                            System.out.println(prod.getNome() + " - R$ " + prod.getPreco());
                        }
                        break;
                    case 3:
                        int id;
                        System.out.print("ID do produto para listar:");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Novo Nome:");
                        nome = sc.nextLine();
                        System.out.print("Preco:");
                        preco = sc.nextDouble();
                        sc.nextLine();
                        p = new Produto(nome, preco);
                        p.setId(id);
                        pdao.atualizar(p);
                        break;
                    case 4:
                        System.out.print("ID do produto para listar:");
                        id = sc.nextInt();
                        sc.nextLine();
                        pdao.deletar(id);
                        break;
                    default:
                        System.out.print("Opcao invalida:");
                        break;
                }

                break;
            case 3:
             Screen tela = new Screen();
            break;
            
            default:
                System.out.print("Opcao invalida:");
                break;

        }
        }

    }
}
