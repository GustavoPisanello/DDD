public class Mago extends Personagem{
    public Mago(String nome, int vidas, int mana){
        super(nome, vidas, mana);
    }

    @Override
    public void atacar(){
        System.out.println(nome +  "O mago usa sua magia");
        mana -= 1;
    }
}
