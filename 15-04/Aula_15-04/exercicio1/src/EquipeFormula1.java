import java.util.ArrayList;
import java.util.List;

public class EquipeFormula1 {
    private List<EquipeF1> membros = new ArrayList<>();

    public void adicionarMembro(EquipeF1 membro){
        membros.add(membro);
    }

    public void iniciarOperacao(){
        for (EquipeF1 membro : membros){
            membro.trabalhar();
        }
    }

    public void statusGeral(){
        for (EquipeF1 membro: membros){
            membro.mostrarStatus();
        }
    }
}
