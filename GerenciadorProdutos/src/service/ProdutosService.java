package service;

import java.util.ArrayList;
import dao.ProdutosDAO;
import modelo.Produtos;

public class ProdutosService {
	
	private ProdutosDAO produtosDAO;
	
	public ProdutosService() {
		this.produtosDAO = new ProdutosDAO();
	}
	
	public void cadastrar(Produtos produtos) {
		this.produtosDAO.cadastrar(produtos);
	}
	
	public void alterar(Produtos produtos) {
		this.produtosDAO.alterar(produtos);
	}
	
	public void excluir(Produtos produtos) {
		this.produtosDAO.excluir(produtos);
	}
	
	public Produtos consultar(int codigo) {
		return this.produtosDAO.consultar(codigo);
	}
	
	public ArrayList<Produtos> listarProdutos() {
		return this.produtosDAO.listarProdutos();
	}

}
