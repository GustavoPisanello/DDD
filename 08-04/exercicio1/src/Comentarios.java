public class Comentarios {
    public static void main(String[] args){
        //Este é um comentário de linha única explicando o próximo código
        System.out.println("Olá, mundo!");

        /*
         * Este é um comentáio de múltiplas linhas.
         * ELe é útil para explicar detalhes mais complexos
         * ou descrever grandes blocos de código
         */
        int resultado = somar(5, 3); // Soma dois números.
        System.out.println("Resultado: " + resultado);
    }

    //Método para somar dois números
    public static int somar(int a, int b){
        return a + b;
    }
}
