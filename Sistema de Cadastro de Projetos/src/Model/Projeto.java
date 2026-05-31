package Model;

public class Projeto {
	
	private int id;
	private String nome;
	private String descricao;
	private String dataInicio;
	private String dataTermino;
	private String status;
	private String nomeGerente;
	
	public Projeto(int id, String nome, String descricao, String dataInicio, String dataTermino,
			String status, String nomeGerente) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.status = status;
		this.nomeGerente = nomeGerente;
		
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
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNomeGerente() {
		return nomeGerente;
	}
	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + " | " + nome + " | " + status
	             + " | Início: " + dataInicio + " | Término: " + dataTermino
	             + " | Gerente: " + nomeGerente;
	}
	
}
