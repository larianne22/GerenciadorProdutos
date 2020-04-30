<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="service.ProdutosService" %>
    <%@ page import="java.util.ArrayList, modelo.Produtos" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de produtos</title>
</head>
<body>
	<table  border='1'>
		<tr>
			<th>Nome</th>
			<th>Descricao</th>
			<th>Estoque</th>
			<th>Valor</th>
			<th>Codigo</th>
		</tr>
	
	<%
		ArrayList<Produtos> lista;
	ProdutosService ps = new ProdutosService();
	lista = ps.listarProdutos();
		
	for (Produtos p : lista){
	%>
	
	<tr>
		<td><%= p.getNome()%> </td> 
		<td><%= p.getDescricao()%></td>
		<td><%= p.getEstoque()%></td>
		<td><%= p.getValor()%></td>
		<td><%= p.getCodigo()%></td>
	</tr>
	
	<% } %>
	
	</table>
	
</body>
</html>