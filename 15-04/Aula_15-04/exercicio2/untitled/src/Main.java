public class Main {
    public static void main(String[] args) {
        OperacoesChamado chamado1 = new ChamadoSuporte();
        chamado1.criarChamado("Problema no email", "Não consigo acessar meu email");
        chamado1.atenderChamado();
        chamado1.fecharChamado();

        System.out.println("------------//-----------");

        OperacoesChamado chamado2 = new ChamadoTI();
        chamado2.criarChamado("Computador travando", "O pc está muito lento");
        chamado2.atenderChamado();
        chamado2.fecharChamado();
    }
}