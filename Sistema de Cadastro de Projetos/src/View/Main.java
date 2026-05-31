package View;

import Controller.EquipeController;
import Controller.ProjetoController;
import Controller.UsuarioController;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioView usuarioView = new UsuarioView(scanner);
        ProjetoView projetoView = new ProjetoView(scanner);
        EquipeView  equipeView  = new EquipeView(scanner);


        UsuarioController usuarioController = new UsuarioController(usuarioView, scanner);
        ProjetoController projetoController = new ProjetoController(projetoView, scanner);
        EquipeController  equipeController  = new EquipeController(equipeView, scanner);

        // Menu principal
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== SISTEMA DE GESTAO DE PROJETOS ===");
            System.out.println("1. Usuarios");
            System.out.println("2. Projetos");
            System.out.println("3. Equipes");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                usuarioController.iniciar();
            } else if (opcao.equals("2")) {
                projetoController.iniciar();
            } else if (opcao.equals("3")) {
                equipeController.iniciar();
            } else if (opcao.equals("0")) {
                System.out.println("Encerrando...");
                rodando = false;
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        scanner.close();
    }
}
