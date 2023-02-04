package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/javacrud?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "!root";

	// Método de Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/* CRUD CREATE */
	public void inserirProduto(Javabeans produto) {
		String create = "insert into produto(nome,categoria,quantidade,preco) values(?,?,?,?)";
		try {
			// abrir a conexão com o banco
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros(?) pelo conteudo das váriaveis Javabeans
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getCategoria());
			pst.setString(3, produto.getQuantidade());
			pst.setString(4, produto.getPreco());
			// Executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		}

	/** CRUD READ **/
	public ArrayList<Javabeans> listarProduto() {
		// Criando um objeto para acessar a classe Javabeans
		ArrayList<Javabeans> produto = new ArrayList<>();
		String read = "select * from produto order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String categoria = rs.getString(3);
				String quantidade = rs.getString(4);
				String preco = rs.getString(5);
				// populado o ArrayList
				produto.add(new Javabeans(id, nome, categoria, quantidade, preco));
			}
			con.close();
			return produto;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		}
	/**CRUD UPDATE**/
	//selecionar produto
	public void selecionarProduto(Javabeans produto) {
		String read2 = "select * from produto where id = ?";
		try {
			Connection con = conectar(); 
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1,produto.getId());
			ResultSet rs = pst.executeQuery(); 
			while(rs.next()) {
				//setar as variáveis do Javabeans
				produto.setId(rs.getString(1));
				produto.setNome(rs.getString(2));
				produto.setCategoria(rs.getString(3));
				produto.setQuantidade(rs.getString(4));
				produto.setPreco(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	//Editar o produto
	public void alterarProduto(Javabeans produto) {
		String update = "update produto set nome=?,categoria=?,quantidade=?,preco=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getCategoria());
			pst.setString(3, produto.getQuantidade());
			pst.setString(4, produto.getPreco());
			pst.setString(5, produto.getId());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**CRUD DELETE**/
	public void deletarProduto(Javabeans produto) {
	 String delete = "delete from produto where id=?";
			 try {
				 Connection con = conectar();
				 PreparedStatement pst = con.prepareStatement(delete);
				 pst.setString(1, produto.getId());
				 pst.executeUpdate();
				 con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
	}

	
	}

