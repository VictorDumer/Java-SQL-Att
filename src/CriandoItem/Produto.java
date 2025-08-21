package CriandoItem;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(String nome, Double preco){
        this.nome=nome;
        this.preco=preco;
    }
    public Produto(String nome, Double preco,int id){
        this.nome=nome;
        this.preco=preco;
        this.id=id;
    }
    
    public int getId() {
        return id;
    }
    
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Preço: R$ " + preco;
    }

    public String getNome() {
        return nome;
    }


    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
