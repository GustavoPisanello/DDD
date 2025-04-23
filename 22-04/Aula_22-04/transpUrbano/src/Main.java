//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Onibus onibus = new Onibus("1896-10", 50, 5.00);
        Metro metro = new Metro("Linha 7 Rubi", 2500, 5.50);
        Bicicleta bike = new Bicicleta("BMX 500", 2, 0);

        onibus.mover();
        metro.mover();
        bike.mover();

        onibus.exibirInfo();
        metro.exibirInfo();
        bike.exibirInfo();

        onibus.ehEcologico();
        metro.ehEcologico();
        bike.ehEcologico();
    }
}