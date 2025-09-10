package model;

import lombok.Data;

@Data
public class Aluno {
    private Long id;
    private String nome;
    private String curso;

    public Aluno(Long id, String nome, String curso){
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }
}
