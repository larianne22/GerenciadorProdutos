package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produtos;
import service.ProdutosService;
import java.util.ArrayList;

@WebServlet("/ListarProdutos.do")
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutosService produtosService = new ProdutosService();
		
		ArrayList<Produtos>listaProdutos = null;
		
		listaProdutos = produtosService.listarProdutos();
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<table border='1'>");
		
		saida.println("<th> Nome do produto </th>");
		saida.println("<th> Descricao </th>");
		saida.println("<th> Estoque </th>");
		saida.println("<th> Valor </th>");
		saida.println("<th> Codigo </th>");
		saida.println("<th> Ação1 </th>");
		saida.println("<th> Ação2 </th>");
		saida.println("<th> Ação3 </th>");
		
		
		listaProdutos.forEach(
				p -> {
					saida.println("<tr>");
					saida.println("<td>");
					saida.println(p.getNome());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getDescricao());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getEstoque());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getValor());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getCodigo());
					saida.println("</td>");
					
					saida.println("<td>");
					saida.println("<a href='AlterarProdutos.do?codigo_produto="
							+ p.getCodigo() + "'> Alterar </a> ");
					saida.println("</td>");
					
					saida.println("<td>");
					saida.println("<a href='index.html'> Adicionar </a> ");
					saida.println("</td>");
					
					saida.println("<td>");
					saida.println("<a href='ExcluirProdutos.do?codigo_produto="
							+ p.getCodigo() + "'> Excluir </a> ");
					saida.println("</td>");
					
					saida.println("</tr>");
				
				}
		    );
		
		    saida.println("</table>");
	}
}
