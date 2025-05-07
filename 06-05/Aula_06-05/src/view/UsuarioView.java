package view;

import java.util.Scanner;

public class UsuarioView {
    private Scanner sc;

    public UsuarioView(){
        sc = new Scanner(System.in);
    }

    public String solicitarNome(){
        System.out.println("Digite o nome do usuário: ");
        return sc.nextLine();
    }

    public int solicitarIdade(){
        System.out.println("Digite a idade do usuário: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarMensagem(String mensagem){
        System.out.println(mensagem);
    }
}
