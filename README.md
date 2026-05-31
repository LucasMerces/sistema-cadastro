Sistema de Gestão de Projetos

Trabalho acadêmico desenvolvido em Java.  
O sistema permite cadastrar e gerenciar usuários, projetos e equipes via terminal.

---

Integrantes

- Hernandes Lima Carvalho
- Lucas Mercês Silva
- Luis Eduardo Alves Bizarro Silva
- Maria Eduarda de Almeida Pinto

---

Tecnologias

- Java 21
- Terminal / Console
- Padrão MVC (Model - View - Controller)

---

Estrutura do Projeto

src/
├── Main.java
└── gestao/
    ├── model/
    │   ├── Usuario.java
    │   ├── Projeto.java
    │   └── Equipe.java
    ├── view/
    │   ├── UsuarioView.java
    │   ├── ProjetoView.java
    │   └── EquipeView.java
    └── controller/
        ├── UsuarioController.java
        ├── ProjetoController.java
        └── EquipeController.java

Funcionalidades

Usuários
- Cadastrar usuário com nome, CPF, e-mail, cargo, login, senha e perfil
- Perfis disponíveis: Administrador, Gerente e Colaborador
- Listar, atualizar e excluir usuários

Projetos
- Cadastrar projeto com nome, descrição, datas e gerente responsável
- Status: Planejado, Em Andamento, Concluído ou Cancelado
- Listar, atualizar e excluir projetos

Equipes
- Cadastrar equipe com nome e descrição
- Adicionar membros e vincular projetos à equipe
- Listar e ver detalhes de cada equipe

Como executar

Opção 1 — pelo JAR:

java -jar sistema-simples.jar

Opção 2 — compilando na mão:
javac -d out $(find src -name "*.java")
java -cp out Main


Padrão MVC

| Camada | Responsabilidade |
|---|---|
| **Model** | Classes de dados (Usuario, Projeto, Equipe) |
| **View** | Menus e leitura do teclado |
| **Controller** | Lógica do sistema e arrays de objetos |
