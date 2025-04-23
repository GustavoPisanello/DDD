//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Personagem p1 = new Mago("Merlin", 100, 90);
        Personagem p2 = new Guerreiro("Arthur", 100, 90);

        p1.mover();
        p2.mover();

        p1.atacar();
        p2.atacar();
    }
}