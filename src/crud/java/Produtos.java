package crud.java;

public class Produtos {

    private int id;
    private String nome;
    private int quantidade;
    private double valorProduto;

    public Produtos(int id, String nome, double valorProduto, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

   
    public String imprimir() {
        return "ID: " + id + ", \nNome: " + nome + ", \nQuantidade: " + quantidade + ", \nValor: " + valorProduto;
    }
}
