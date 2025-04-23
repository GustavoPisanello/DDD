public abstract class Personagem {
    protected int vidas;
    protected String nome;
    protected int mana;

    public Personagem(String nome, int vidas, int mana){
        this.nome = nome;
        this.vidas = vidas;
        this.mana = mana;
    }
    public void mover(){
        System.out.println(nome + " está se movendo...");
    }

    protected abstract void atacar();
}
