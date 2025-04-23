public class Armador extends Jogador{
    public Armador(String nome, int numeroCamisa){
        super(nome, numeroCamisa);
    }

    @Override
    public void executarPapel(){
        System.out.println(nome + " organiza o ataque e distribui a bola.");
    }
}
