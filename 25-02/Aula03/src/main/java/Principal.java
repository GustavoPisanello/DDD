import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 8);
        Pessoa pessoa1 = new Pessoa();

        System.out.println(pessoa.getPessoa());
        System.out.println(pessoa1.getPessoa());
    }
}

