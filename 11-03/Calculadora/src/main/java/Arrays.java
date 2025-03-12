public class Arrays {
    public static void main(String[] args){
        int[] notas = new int[4];

        notas[0] = 85;
        notas[1] = 90;
        notas[2] = 78;
        notas[3] = 93;

        System.out.println("Primeira nota: " + notas[0]);

        for (int i = 0; i < notas.length; i ++){
            System.out.println("Nota " + (i+1) + ": " + notas[i]);
        }

        for (int nota: notas){
            System.out.println("Notas: " + nota);
        }
    }
}
