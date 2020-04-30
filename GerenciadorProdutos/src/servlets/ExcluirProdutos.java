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

@WebServlet("/ExcluirProdutos.do")
public class ExcluirProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		
		Produtos produtos = new Produtos();
		produtos.setCodigo(codigo);
		
		ProdutosService produtosService = new ProdutosService();
		produtosService.excluir(produtos);
		
		PrintWriter saida = response.getWriter();
		saida.println("Excluído com sucesso");
	}

}
