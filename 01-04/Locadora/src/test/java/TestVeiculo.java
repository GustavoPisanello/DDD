import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVeiculo {
    @Test
    public void testCustoVeiculo(){
        Veiculo vel = new Veiculo("Ford Ka", 80);
        assertEquals(576, vel.custoVeiculo(8), 0);
    }

    @Test
    public void testCustoVeiculo2(){
        Veiculo vel = new Veiculo("Ford Ka", 80);
        assertEquals(0, vel.custoVeiculo(0), 0);
    }

    @Test
    public void testCustoVeiculo3(){
        Veiculo vel = new Veiculo("Ford Ka", 80);
        assertEquals(0, vel.custoVeiculo(-8), 0);
    }

    @Test
    public void testCalculaMulta(){
        Veiculo vel = new Veiculo("Ford Ka", 80);
        assertEquals(3566.4401793024, vel.calculaValorTotal(8, 10), 0);
    }


}
