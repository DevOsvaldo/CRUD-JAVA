<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Javabeans"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Javabeans> lista = (ArrayList<Javabeans>)request.getAttribute("produto");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="icon" href="imagens/finance_shopping.png">
<link rel="stylesheet" href="style.css">
<meta charset="utf-8">
<title>Produto</title>
</head>
<body>
	<h1>Produto</h1>
	<a href="novo.html" class="botao1">Novo Produto</a>

	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Quantidade</th>
				<th>Preco</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCategoria()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><%=lista.get(i).getPreco()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>"
					class="botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId()%>)"
					class="botao2">Excluir</a>
					</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="index.html" class="voltar">Voltar</a>
	<script src="scripts/confirmador.js"></script>
</body>
</html>