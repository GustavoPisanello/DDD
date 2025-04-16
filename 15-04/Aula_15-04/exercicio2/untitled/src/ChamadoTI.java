public class ChamadoTI implements OperacoesChamado{
    private String titulo;
    private String descricao;

    @Override
    public void criarChamado(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        System.out.println("Chamado de TI criado: " + titulo);
    }

    @Override
    public void atenderChamado(){
        System.out.println("Suporte técnico atendendo chamado: " + titulo);
    }

    @Override
    public void fecharChamado(){
        System.out.println("Atendimento finalizado");
    }
}
