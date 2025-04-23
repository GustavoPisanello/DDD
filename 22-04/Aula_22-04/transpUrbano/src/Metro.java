public class Metro extends TransporteUrbano{
    public Metro(String nome, int capacidade, double custo){
        super(nome, capacidade, custo, false);
    }

    @Override
    public void mover(){
        System.out.println("O metrô " + nome + " está saindo da estação");
    }

    @Override
    public void exibirInfo(){
        System.out.println("O meio de transporte " + nome + " possui capacidade de " + capacidade + " pessoas e custa " + custo + " reais");
    }
}
