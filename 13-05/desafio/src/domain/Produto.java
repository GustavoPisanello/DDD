package domain;

public class Produto {
    String nome;
    double preco;
    Integer codigo;

    public Produto(String nome, double preco, Integer codigo){
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }

    public Integer getId(){
        return codigo;
    }
}
