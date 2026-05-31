package View;

import java.util.Scanner;

public class EquipeView {
	Scanner scanner = new Scanner(System.in);

    public EquipeView (Scanner scanner) {
        this.scanner = scanner;
    }
    
	public void exibirMenu() {
        System.out.println("\n=== EQUIPES ===");
        System.out.println("1. Cadastrar");
        System.out.println("2. Listar");
        System.out.println("3. Ver detalhes");
        System.out.println("4. Adicionar membro");
        System.out.println("5. Vincular projeto");
        System.out.println("6. Excluir");
        System.out.println("0. Voltar");
        System.out.print("Opcao: ");
    }
	
	public String[] pedirDadosCadastro() {
        System.out.println("\n-- Cadastrar Equipe --");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();
        return new String[]{ nome, descricao };
    }
	
	public int pedirId(String acao) {
        System.out.print("ID da equipe para " + acao + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirNomeMembro() {
        System.out.print("Nome do membro a adicionar: ");
        return scanner.nextLine();
    }

    public String pedirNomeProjeto() {
        System.out.print("Nome do projeto a vincular: ");
        return scanner.nextLine();
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

}
