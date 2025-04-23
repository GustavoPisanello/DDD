public class Onibus extends TransporteUrbano{
    public Onibus(String nome, int capacidade, double custo){
        super(nome, capacidade, custo, false);
    }

    @Override
    public void mover(){
        System.out.println("O ônibus " + nome + " está saindo do ponto");
    }

    @Override
    public void exibirInfo(){
        System.out.println("O meio de transporte " + nome + " possui capacidade de " + capacidade + " pessoas e custa " + custo + " reais");
    }
}
