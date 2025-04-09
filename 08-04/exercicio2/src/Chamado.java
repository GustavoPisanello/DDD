import java.time.LocalDate;

public class Chamado {
    /** Variável identificadora */
    private int id;
    /** Variável que guarda a descrição */
    private String descricao;
    /** Variável que guarda o responsável */
    private String responsavel;
    /** Variável que guarda a data de abertura */
    private LocalDate dataAbertura;
    /** Variável que guarda a data de Fechamento */
    private LocalDate dataFechamento;

    /**
     * Função que abre um chamado.
     *
     * @param id Variável identificadora
     * @param descricao Parâmetro da descrição
     * @param responsavel Parâmetro do responsável
     * @param dataAbertura Parâmetro da data de abertura
     */
    public Chamado(int id, String descricao, String responsavel, LocalDate dataAbertura){
        this.id = id;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = null;
    }
}
