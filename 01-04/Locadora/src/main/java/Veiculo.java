import java.text.DecimalFormat;
import java.util.Locale;

public class Veiculo {
    String modelo;
    double valorDiaria;

    public Veiculo(String modelo, double valorDiaria){
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    public double custoVeiculo(int dias){
        double desconto = aplicaDesconto(dias, 0.10);
        return valorDiaria * dias - (valorDiaria * dias * desconto);
    }

    public double aplicaDesconto(int dias, double desconto){
        return dias <= 7 ? 1 : desconto;
    }

    public double calculaMultas(int diasDeUso, int diasDeAtraso){
        double juroPorDia = 0.2;
        double total = custoVeiculo(diasDeUso);
        for (int i = 0; i < diasDeAtraso; i++){
            double totalNoDia = total * juroPorDia;
            total += totalNoDia;
        }
        return total;
    }
}
