package View;

import java.util.Scanner;

public class ProjetoView {

    private Scanner scanner;

    public ProjetoView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        System.out.println("\n=== PROJETOS ===");
        System.out.println("1. Cadastrar");
        System.out.println("2. Listar");
        System.out.println("3. Atualizar");
        System.out.println("4. Excluir");
        System.out.println("0. Voltar");
        System.out.print("Opcao: ");
    }

    public String[] pedirDadosCadastro() {
        System.out.println("\n-- Cadastrar Projeto --");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de inicio (dd/mm/aaaa): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Data de termino (dd/mm/aaaa): ");
        String dataTermino = scanner.nextLine();
        System.out.println("Status: 1-Planejado  2-Em Andamento  3-Concluido  4-Cancelado");
        System.out.print("Opcao: ");
        String opcaoStatus = scanner.nextLine();
        System.out.print("Nome do gerente responsavel: ");
        String nomeGerente = scanner.nextLine();

        String status;
        if (opcaoStatus.equals("1")) {
            status = "Planejado";
        } else if (opcaoStatus.equals("2")) {
            status = "Em Andamento";
        } else if (opcaoStatus.equals("3")) {
            status = "Concluido";
        } else {
            status = "Cancelado";
        }

        return new String[]{ nome, descricao, dataInicio, dataTermino, status, nomeGerente };
    }

    public int pedirId(String acao) {
        System.out.print("ID do projeto para " + acao + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirNovoStatus(String atual) {
        System.out.println("Status atual: " + atual);
        System.out.println("1-Planejado  2-Em Andamento  3-Concluido  4-Cancelado  Enter-Manter");
        System.out.print("Opcao: ");
        String v = scanner.nextLine();
        if (v.equals("1")) return "Planejado";
        if (v.equals("2")) return "Em Andamento";
        if (v.equals("3")) return "Concluido";
        if (v.equals("4")) return "Cancelado";
        return atual;
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
