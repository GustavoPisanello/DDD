public class Guerreiro extends Personagem{
    public Guerreiro(String nome, int vidas, int mana){
        super(nome, vidas, mana);
    }

    @Override
    public void atacar(){
        System.out.println(nome + " ATACA COM SUA ESPADA!");
    }
}
