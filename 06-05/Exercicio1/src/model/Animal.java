package model;

public class Animal {
    String nome;
    int idade;
    String especie;

    public Animal(String nome, int idade, String especie){
        this.especie = especie;
        this.nome = nome;
        this.especie = especie;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getEspecie(){
        return especie;
    }
}
