package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.Javabeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Javabeans produto = new Javabeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			produto(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);

		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar produtos
	protected void produto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um Objeto que receberá o dados Javabeans
		ArrayList<Javabeans> lista = dao.listarProduto();
		// Encaminhar a lista ao documento produto.jsp
		request.setAttribute("produto", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
		rd.forward(request, response);
	}

	// Novo Produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variáveis Javabeans
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setPreco(request.getParameter("preco"));
		// Invocar o metodo inserirProduto passando o objeto produto
		dao.inserirProduto(produto);
		// Redirecionar para o documento produto.jsp
		response.sendRedirect("main");
	}

	// Editar Produto
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebendo o id do produto que será editado
		String id = request.getParameter("id");
		// Setando a variável Jetbeans
		produto.setId(id);
		// Executar o método selecionarProduto
		dao.selecionarProduto(produto);
		// setar os atributos do formulário com o conteúdo do Javabeans
		request.setAttribute("id", produto.getId());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("quantidade", produto.getQuantidade());
		request.setAttribute("preco", produto.getPreco());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	//
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis Javabeans
		produto.setId(request.getParameter("id"));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setPreco(request.getParameter("preco"));
		// executar o metodo alterarProduto
		dao.alterarProduto(produto);
		// redirecionar para o doumento produto.jsp(atualizando as alterações)
		response.sendRedirect("main");
	}
	//Remover Produto
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recebimento do id do produto a ser excluido(validador.js)
		String id = request.getParameter("id");
		//setar variáveis com o id Javabeans
		produto.setId(id);
		//executar o metodo deletarProduto
		dao.deletarProduto(produto);
		// redirecionar para o doumento produto.jsp(atualizando as alterações)
		response.sendRedirect("main");
	}
}
