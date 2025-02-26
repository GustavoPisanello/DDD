
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(){
        this.nome = "Sem nome";
        this.idade = 0;
    }

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getPessoa(){
        return (String.format("Nome: %s \nIdade: %d", nome, idade));
    }
}