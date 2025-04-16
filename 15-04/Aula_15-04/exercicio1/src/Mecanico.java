public class Mecanico implements EquipeF1{
    private String nome;

    public Mecanico(String nome){
        this.nome = nome;
    }

    @Override
    public void trabalhar(){
        System.out.println(nome + " está consertando o carro");
    }

    @Override
    public void mostrarStatus(){
        System.out.println(nome + " está em 50% da manutenção");
    }
}
