public class Bicicleta extends TransporteUrbano {
    public Bicicleta(String nome, int capacidade, double custo){
        super(nome, capacidade, custo, true);
    }

    @Override
    public void mover(){
        System.out.println("A bike" + nome + " está se movendo");
    }

    @Override
    public void exibirInfo(){
        System.out.println("O meio de transporte " + nome + " possui capacidade de " + capacidade + " pessoas e custa " + custo + " reais");
    }
}
