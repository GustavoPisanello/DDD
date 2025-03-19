import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de valores que deseja formatar: ");
        int qty = sc.nextInt();

        double[] values = new double[qty];

        for (int i = 0; i < qty; i++){
            System.out.println("Digite o " + (i + 1) + "° valor");
            double value = sc.nextDouble();
            values[i] = value;
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');

        Printer printer = new Printer();
        printer.print(qty, symbols, values);
    }
}
