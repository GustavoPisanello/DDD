package controller;

import model.Animal;
import model.Diagnostico;
import view.DiagnosticoView;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticoController {
    List<Animal> animais = new ArrayList<>();
    List<Diagnostico> diagnosticos = new ArrayList<>();
    DiagnosticoView view = new DiagnosticoView();

    public DiagnosticoController(DiagnosticoView view){
        this.view = view;
    }

    public void adicionarAnimal(Animal animal){
        animais.add(animal);
    }

    public void adicionarDiagnostico(){
        for (Animal animal: animais){

        }
    }
}
