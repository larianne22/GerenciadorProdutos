package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutosDAO;
import modelo.Produtos;

@WebServlet("/TesteDAO.do")
public class TesteDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produtos p = new Produtos (1, "Pote", "Guardar", 
				7.00, 5);
			
			ProdutosDAO pDAO = new ProdutosDAO();
			
			pDAO.alterar(p);
			
			// Teste de consulta:
			p = pDAO.consultar(1);
			
			//System.out.println(p1.getNome());	}
			
			System.out.println(pDAO.listarProdutos().size());
	}

}
