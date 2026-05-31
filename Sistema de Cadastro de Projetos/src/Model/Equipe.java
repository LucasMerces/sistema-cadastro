package Model;

public class Equipe {
	
	private int id;
	private String nome;
	private String descricao;
	private String[] membros = new String[10];
	private String[] projetos = new String[10];
	private int qtdMembros = 0;
	private int qtdProjetos = 0;
	
	public Equipe(int id, String nome, String descricao) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] getMembros() {
		return membros;
	}

	public void setMembros(String[] membros) {
		this.membros = membros;
	}

	public String[] getProjetos() {
		return projetos;
	}

	public void setProjetos(String[] projeto) {
		this.projetos = projeto;
	}

	public int getQtdMembros() {
		return qtdMembros;
	}

	public void setQtdMembros(int qtdMembros) {
		this.qtdMembros = qtdMembros;
	}

	public int getQtdProjetos() {
		return qtdProjetos;
	}

	public void setQtdProjetos(int qtdProjeto) {
		this.qtdProjetos = qtdProjeto;
	}
	
	public boolean adicionarMembro(String nomeMembro) {
		if(qtdMembros >= 10) return false;
		membros[qtdMembros] = nomeMembro;
		qtdMembros++;
		return true;
	}
	
	public boolean adicionarProjeto(String nomeProjeto) {
		if(qtdProjetos >= 10) return false;
		projetos[qtdProjetos] = nomeProjeto;
		qtdProjetos++;
		return true;
	}
	
	public String toString() {
        return "ID: " + id + " | " + nome
             + " | Membros: " + qtdMembros
             + " | Projetos: " + qtdProjetos
             + " | " + descricao;
    }
}
