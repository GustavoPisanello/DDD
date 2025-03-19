import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Printer {
    public void print(int qty, DecimalFormatSymbols symbols, double[] list) {
        int i = 0;
        while (i < qty) {
            DecimalFormat format = new DecimalFormat("#.##", symbols);
            System.out.println(format.format(list[i]));
            i++;
        }
    }
}
