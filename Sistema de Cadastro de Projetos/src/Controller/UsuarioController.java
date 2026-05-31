package Controller;

import Model.Usuario;
import View.UsuarioView;
import java.util.Scanner;

public class UsuarioController {

    private Usuario[] usuarios = new Usuario[100];
    private int qtd = 0;
    private int proximoId = 1;

    private UsuarioView view;
    private Scanner scanner;

    public UsuarioController(UsuarioView view, Scanner scanner) {
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
        // dados: [nome, cpf, email, cargo, login, senha, perfil]

        for (int i = 0; i < qtd; i++) {
            if (usuarios[i].getLogin().equals(dados[4])) {
                view.mostrarMensagem("Erro: login ja existe.");
                return;
            }
        }

        Usuario novo = new Usuario(proximoId, dados[0], dados[1], dados[2],
                                   dados[3], dados[4], dados[5], dados[6]);
        usuarios[qtd] = novo;
        qtd++;
        proximoId++;
        view.mostrarMensagem("Usuario cadastrado! ID: " + novo.getId());
    }

    private void listar() {
        if (qtd == 0) {
            view.mostrarMensagem("Nenhum usuario cadastrado.");
            return;
        }
        System.out.println("\n-- Lista de Usuarios --");
        for (int i = 0; i < qtd; i++) {
            System.out.println(usuarios[i]);
        }
    }

    private void atualizar() {
        System.out.print("ID do usuario para atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Usuario nao encontrado.");
            return;
        }

        Usuario u = usuarios[pos];
        String novoNome  = view.pedirNovoNome(u.getNome());
        String novoEmail = view.pedirNovoEmail(u.getEmail());
        String novoCargo = view.pedirNovoCargo(u.getCargo());

        u.setNome(novoNome);
        u.setEmail(novoEmail);
        u.setCargo(novoCargo);
        view.mostrarMensagem("Usuario atualizado!");
    }

    private void excluir() {
        System.out.print("ID do usuario para excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        int pos = buscarPosicao(id);

        if (pos == -1) {
            view.mostrarMensagem("Usuario nao encontrado.");
            return;
        }

        for (int i = pos; i < qtd - 1; i++) {
            usuarios[i] = usuarios[i + 1];
        }
        usuarios[qtd - 1] = null;
        qtd--;
        view.mostrarMensagem("Usuario excluido!");
    }

    private int buscarPosicao(int id) {
        for (int i = 0; i < qtd; i++) {
            if (usuarios[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Usuario buscarPorId(int id) {
        int pos = buscarPosicao(id);
        if (pos == -1) return null;
        return usuarios[pos];
    }

    public Usuario[] getUsuarios() { return usuarios; }
    public int getQtd()            { return qtd; }
}
