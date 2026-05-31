package Controller;

import Model.Equipe;
import java.util.Scanner;
import View.EquipeView;

public class EquipeController {
	private Equipe[] equipes = new Equipe[100];
    private int qtd = 0;
    private int proximoId = 1;
    private EquipeView view;
    private Scanner scanner;
    
    public EquipeController(EquipeView view, Scanner scanner) {
    	this.view    = view;
        this.scanner = scanner;
    }
    
    public void iniciar() {
    	boolean rodando = true;
    	while(rodando) {
    		view.exibirMenu();
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                cadastrar();
            } else if (opcao.equals("2")) {
                listar();
            } else if (opcao.equals("3")) {
                verDetalhes();
            } else if (opcao.equals("4")) {
                adicionarMembro();
            } else if (opcao.equals("5")) {
                vincularProjeto();
            } else if (opcao.equals("6")) {
                excluir();
            } else if (opcao.equals("0")) {
                rodando = false;
            } else {
                view.mostrarMensagem("Opcao invalida.");
            }
    	}
    }
    private void cadastrar() {
        String[] dados = view.pedirDadosCadastro();

        Equipe nova = new Equipe(proximoId, dados[0], dados[1]);
        equipes[qtd] = nova;
        qtd++;
        proximoId++;
        view.mostrarMensagem("Equipe cadastrada! ID: " + nova.getId());
    }

    private void listar() {
        if (qtd == 0) {
            view.mostrarMensagem("Nenhuma equipe cadastrada.");
            return;
        }
        System.out.println("\n-- Lista de Equipes --");
        for (int i = 0; i < qtd; i++) {
            System.out.println(equipes[i]);
        }
    }

    private void verDetalhes() {
        System.out.print("ID da equipe: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Equipe nao encontrada.");
            return;
        }

        Equipe e = equipes[pos];
        System.out.println("\nNome: " + e.getNome());
        System.out.println("Descricao: " + e.getDescricao());

        System.out.println("Membros (" + e.getQtdMembros() + "):");
        for (int i = 0; i < e.getQtdMembros(); i++) {
            System.out.println("  - " + e.getMembros()[i]);
        }

        System.out.println("Projetos (" + e.getQtdProjetos() + "):");
        for (int i = 0; i < e.getQtdProjetos(); i++) {
            System.out.println("  - " + e.getProjetos()[i]);
        }
    }

    private void adicionarMembro() {
        System.out.print("ID da equipe: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Equipe nao encontrada.");
            return;
        }

        String nomeMembro = view.pedirNomeMembro();
        boolean ok = equipes[pos].adicionarMembro(nomeMembro);

        if (ok) {
            view.mostrarMensagem("Membro adicionado!");
        } else {
            view.mostrarMensagem("Equipe cheia (maximo 10 membros).");
        }
    }

    private void vincularProjeto() {
        System.out.print("ID da equipe: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Equipe nao encontrada.");
            return;
        }

        String nomeProjeto = view.pedirNomeProjeto();
        boolean ok = equipes[pos].adicionarProjeto(nomeProjeto);

        if (ok) {
            view.mostrarMensagem("Projeto vinculado!");
        } else {
            view.mostrarMensagem("Limite de projetos atingido (maximo 10).");
        }
    }

    private void excluir() {
        System.out.print("ID da equipe para excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Equipe nao encontrada.");
            return;
        }

        for (int i = pos; i < qtd - 1; i++) {
            equipes[i] = equipes[i + 1];
        }
        equipes[qtd - 1] = null;
        qtd--;
        view.mostrarMensagem("Equipe excluida!");
    }

    private int buscarPosicao(int id) {
        for (int i = 0; i < qtd; i++) {
            if (equipes[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
