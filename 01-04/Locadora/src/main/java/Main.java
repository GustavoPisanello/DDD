import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        insereDados();
    }
    public static void insereDados(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o modelo do veículo: ");
        String modelo = sc.nextLine();

        System.out.println("Insira a diária do veículo: ");
        double valorDiaria = sc.nextDouble();
        Veiculo vel = new Veiculo(modelo, valorDiaria);

        System.out.println("Insira os dias de uso do veículo: ");
        int diasDeUso = sc.nextInt();

        System.out.println("Insira os dias de atraso do veículo: ");
        int diasDeAtraso = sc.nextInt();

        System.out.printf("%.2f", vel.calculaMultas(diasDeUso, diasDeAtraso));

    }
}