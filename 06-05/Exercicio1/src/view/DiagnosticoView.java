package view;

import java.util.Scanner;

public class DiagnosticoView {
    Scanner sc;

    public DiagnosticoView(){
        sc = new Scanner(System.in);
    }

    public String mostrarRelatorio() {

    }
    public String solicitarNome(){
        System.out.println("Digite o nome do animal: ");
        return sc.nextLine();
    }

    public int solicitarIdade(){
        System.out.println("Digite a idade do animal: ");
        return sc.nextInt();
    }

    public int solicitarEspecie(){
        System.out.println("Digite a espécie do animal: ");
        return sc.nextInt();
    }

}
