package br.com.livraria.bean;

public class Livro {
	private Integer id;
	private String nome;
	private Integer edicao;
	
	
	public Livro() {
	}

	public Livro(Integer id) {
		this.id = id;
	}

	
	public Livro(Integer id, String nome, Integer edicao) {
		this.id = id;
		this.nome = nome;
		this.edicao = edicao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

}
