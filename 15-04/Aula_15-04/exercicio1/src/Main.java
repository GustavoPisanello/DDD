public class Main {
    public static void main(String[] args) {
        Piloto piloto = new Piloto("Max Verstappen");
        Engenheiro engenheiro = new Engenheiro("Leozão");

        EquipeFormula1 ef1 = new EquipeFormula1();

        ef1.adicionarMembro(piloto);
        ef1.adicionarMembro(engenheiro);
        ef1.iniciarOperacao();
        ef1.statusGeral();
    }
}