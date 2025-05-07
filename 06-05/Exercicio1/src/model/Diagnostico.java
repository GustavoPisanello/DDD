package model;

public class Diagnostico {
    String nomeAnimal;
    String descDiagnostico;

    public Diagnostico(String nomeAnimal, String descDiagnostico){
        this.descDiagnostico = descDiagnostico;
        this.nomeAnimal = nomeAnimal;
    }

    public void setNome(String nome){
        this.nomeAnimal = nome;
    }

    public void setDescDiagnostico(String descDiagnostico){
        this.descDiagnostico = descDiagnostico;
    }

    public String getNome(){
        return nomeAnimal;
    }

    public String getDescDiagnostico(){
        return descDiagnostico;
    }
}
