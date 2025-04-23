public abstract class TransporteUrbano implements meioEcologico {
    public String nome;
    public int capacidade;
    public double custo;
    protected boolean ehEcologico;

    public TransporteUrbano(String nome, int capacidade, double custo, boolean ehEcologico){
        this.capacidade = capacidade;
        this.custo = custo;
        this.nome = nome;
        this.ehEcologico = ehEcologico;
    }

    @Override
    public void ehEcologico(){
        System.out.println(nome + (ehEcologico ? " É ecológico": " Não é ecológico"));
    }

    public abstract void exibirInfo();
    public abstract void mover();
}
