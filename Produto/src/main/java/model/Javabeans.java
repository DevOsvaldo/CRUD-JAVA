package model;

public class Javabeans {
	private String id;
	private String nome;
	private String categoria;
	private String quantidade;
	private String preco;
		
	
	public Javabeans() {
		super();
		
	}
	
	public Javabeans(String id, String nome, String categoria, String quantidade, String preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getQuantidade() {
		return quantidade;
	}
	
	

}
