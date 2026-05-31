package View;

import java.util.Scanner;

public class UsuarioView {

    private Scanner scanner;

    public UsuarioView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        System.out.println("\n=== USUARIOS ===");
        System.out.println("1. Cadastrar");
        System.out.println("2. Listar");
        System.out.println("3. Atualizar");
        System.out.println("4. Excluir");
        System.out.println("0. Voltar");
        System.out.print("Opcao: ");
    }

    public String[] pedirDadosCadastro() {
        System.out.println("\n-- Cadastrar Usuario --");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.println("Perfil: 1-Administrador  2-Gerente  3-Colaborador");
        System.out.print("Opcao: ");
        String opcaoPerfil = scanner.nextLine();

        String perfil;
        if (opcaoPerfil.equals("1")) {
            perfil = "Administrador";
        } else if (opcaoPerfil.equals("2")) {
            perfil = "Gerente";
        } else {
            perfil = "Colaborador";
        }

        return new String[]{ nome, cpf, email, cargo, login, senha, perfil };
    }

    public int pedirId(String acao) {
        System.out.print("ID do usuario para " + acao + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirNovoNome(String atual) {
        System.out.print("Novo nome [" + atual + "]: ");
        String v = scanner.nextLine();
        return v.isEmpty() ? atual : v;
    }

    public String pedirNovoEmail(String atual) {
        System.out.print("Novo email [" + atual + "]: ");
        String v = scanner.nextLine();
        return v.isEmpty() ? atual : v;
    }

    public String pedirNovoCargo(String atual) {
        System.out.print("Novo cargo [" + atual + "]: ");
        String v = scanner.nextLine();
        return v.isEmpty() ? atual : v;
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
