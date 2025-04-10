import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
     * Construtor da classe Chamado
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

    /**
     * Função que fecha o chamado.
     */
    public void fecharChamado(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * Função que verifica o estado do chamado. {@code Chamado} aberto, {@code Chamado} fechado.
     */
    public boolean estaAberto() {
        return dataFechamento == null;
    }

    /**
     * Função que retorna o id do chamado.
     */
    public int getId() {
        return id;
    }

    /**
     * Função que retorna a descrição do chamado
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Função que retorna o responsável do chamado
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * Função que retorna a data de abertura do chamado
     */
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    /**
     * Função que retorna a data de fechamento do chamado
     */
    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    /**
     * Função que retorna a duração do chamado em dias.
     */
    public long getDuracao() {
        if (dataFechamento != null) {
            return ChronoUnit.DAYS.between(dataAbertura, dataFechamento);
        } else {
            return -1;
        }
    }
}
