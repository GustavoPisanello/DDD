public class Teste{
    public static void main(String[] args){
        Calculadora calc = new Calculadora();
        System.out.println(calc.soma(2, 3));
        System.out.println(calc.soma(2, 3, 4));
        System.out.println(calc.soma(2.5, 3.5));

        Impressora imp = new Impressora();
        imp.imprimir("Oi");
        imp.imprimir(6);

        Filho filho = new Filho();
        filho.mensagem();

        int[] lista = new int[4];
        lista[0] = 34;
        lista[1] = 56;
        lista[2] = 78;
        lista[3] = 90;

        System.out.println(calc.soma(lista));
        System.out.println(calc.sub(lista));
        System.out.println(calc.mult(lista));
        System.out.println(calc.div(lista));

    }

    public static void arrayExercise(){
        int[] numeros = new int[5];
        String[] nomes = {"João", "Maria", "Pedro"};
        double[] precos = new double[]{1.99, 2.99, 3.99};
        int[] notas = new int[4];

        System.out.println(nomes[1]);
    }
}
