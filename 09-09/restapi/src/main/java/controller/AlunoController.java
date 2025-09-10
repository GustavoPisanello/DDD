package controller;

import model.Aluno;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>(
            Arrays.asList(new Aluno(1L, "Maria", "ADS"),
                    new Aluno(2L, "João", "Engenharia de Software"))
    );

    // GET - buscar todos
    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return alunos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST - adicionar novo
    @PostMapping
    public Aluno adicionar(@RequestBody Aluno aluno) {
        aluno.setId((long) (alunos.size() + 1));
        alunos.add(aluno);
        return aluno;
    };

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        Aluno aluno = buscar(id);

        if (aluno != null){
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setCurso(alunoAtualizado.getCurso());
        }

        return aluno;
    };

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunos.removeIf(a -> a.getId().equals(id));
    }

}