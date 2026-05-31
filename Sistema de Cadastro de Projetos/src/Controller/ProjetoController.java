package Controller;

import Model.Projeto;
import View.ProjetoView;
import java.util.Scanner;

public class ProjetoController {

    private Projeto[] projetos = new Projeto[100];
    private int qtd = 0;
    private int proximoId = 1;

    private ProjetoView view;
    private Scanner scanner;

    public ProjetoController(ProjetoView view, Scanner scanner) {
        this.view    = view;
        this.scanner = scanner;
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            view.exibirMenu();
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                cadastrar();
            } else if (opcao.equals("2")) {
                listar();
            } else if (opcao.equals("3")) {
                atualizar();
            } else if (opcao.equals("4")) {
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

        Projeto novo = new Projeto(proximoId, dados[0], dados[1],
                                   dados[2], dados[3], dados[4], dados[5]);
        projetos[qtd] = novo;
        qtd++;
        proximoId++;
        view.mostrarMensagem("Projeto cadastrado! ID: " + novo.getId());
    }

    private void listar() {
        if (qtd == 0) {
            view.mostrarMensagem("Nenhum projeto cadastrado.");
            return;
        }
        System.out.println("\n-- Lista de Projetos --");
        for (int i = 0; i < qtd; i++) {
            System.out.println(projetos[i]);
        }
    }

    private void atualizar() {
        System.out.print("ID do projeto para atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Projeto nao encontrado.");
            return;
        }

        Projeto p = projetos[pos];
        String novoStatus = view.pedirNovoStatus(p.getStatus());
        p.setStatus(novoStatus);
        view.mostrarMensagem("Projeto atualizado!");
    }

    private void excluir() {
        System.out.print("ID do projeto para excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Projeto nao encontrado.");
            return;
        }

        for (int i = pos; i < qtd - 1; i++) {
            projetos[i] = projetos[i + 1];
        }
        projetos[qtd - 1] = null;
        qtd--;
        view.mostrarMensagem("Projeto excluido!");
    }

    private int buscarPosicao(int id) {
        for (int i = 0; i < qtd; i++) {
            if (projetos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Projeto[] getProjetos() { return projetos; }
    public int getQtd()            { return qtd; }
}
