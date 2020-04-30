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

@WebServlet("/AlterarProdutos.do")
public class AlterarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		
		ProdutosService produtosService = new ProdutosService();
		Produtos produtos = produtosService.consultar(codigo);
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		saida.println("<form action='AlterarProdutos.do' method='post'> ");
		saida.println("Codigo: " + produtos.getCodigo());
		saida.println("<input type='hidden' name='codigo_produto' value= '"
				+ produtos.getCodigo() + "'> <br>");
		saida.println("Descricao:");
		saida.println("<input type='text' name='descricao_produto' value= '"
				+ produtos.getDescricao() + "'> <br> ");
		saida.println("Nome: ");
		saida.println("<input type='text' name='nome_produto' value='"
				+ produtos.getNome() + "'> <br> ");
		saida.println("Valor: ");
		saida.println("<input type='text' name='valor_produto' value= "
				+ produtos.getValor() + "'> <br> ");
		saida.println("Estoque: ");
		saida.println("<input type='text' name='estoque_produto' value= "
				+ produtos.getEstoque() + "'> <br> ");
		saida.println("<input type='submit'> ");
		saida.println("</form> ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String descricao = request.getParameter("descricao_produto");
        String nome = request.getParameter("nome_produto");
        double valor = Double.parseDouble(request.getParameter("valor_produto"));
        int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		
		Produtos produtos = new Produtos();
		produtos.setCodigo(codigo);
		produtos.setDescricao(descricao);
		produtos.setNome(nome);
		produtos.setValor(valor);
		produtos.setEstoque(estoque);
		
		ProdutosService produtosService = new ProdutosService();
		produtosService.alterar(produtos);
		
		PrintWriter resposta = response.getWriter();
		resposta.println("Alterado com sucesso");
	}

}
