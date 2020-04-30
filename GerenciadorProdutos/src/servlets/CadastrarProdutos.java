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

@WebServlet("/CadastrarProdutos.do")
public class CadastrarProdutos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome_produto");
		String descricao = request.getParameter("descricao_produto");
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		
		Produtos produtos = new Produtos();
		
		produtos.setNome(nome);
		produtos.setDescricao(descricao);
		produtos.setValor(valor);
		produtos.setEstoque(estoque);
		produtos.setCodigo(codigo);
		
		ProdutosService produtosService = new ProdutosService();
		produtosService.cadastrar(produtos);
		
		PrintWriter saida = response.getWriter();
		
		saida.println("Cadastro efetuado com sucesso!");
		saida.println(" <a href='listaprodutos.jsp'> Clique aqui para listar os produtos </a>");
	}
}
