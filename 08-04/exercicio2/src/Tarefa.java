public class Tarefa {
    /** Variável que guarda o título da tarefa. */
    private String titulo;
    /** Variável que garda a descrição da tarefa. */
    private String descricao;
    /** Variavel que guarda o estado da tarefa. */
    private boolean concluida;

    /**
     * Construtor da classe Tarefa.
     *
     * @param titulo Título da tarefa
     * @param descricao Descrição da tarefa
     */
    public Tarefa(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
    }

    /** Função para concluir a tarefa, que muda o estado de "concluída" para "true" */
    public void concluir(){
        this.concluida = true;
    }

    /** Função para reabrir a tarefa, que muda o estado de "concluída" para "false" */
    public void reabrir(){
        this.concluida = false;
    }

    /** Função que verifica se a tarefa esta concluída ou não */
    public boolean estaConcluida(){
        return concluida;
    }

    /** Função que retorna título da tarefa */
    public String getTitulo(){
        return titulo;
    }

    /** Função que retorna a descrição da tarefa */
    public String getDescricao(){
        return descricao;
    }
}
