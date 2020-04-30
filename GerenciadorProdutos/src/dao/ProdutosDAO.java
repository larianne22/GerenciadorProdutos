package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Produtos;

public class ProdutosDAO {
	
	private Connection conexao;
	
	public ProdutosDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void cadastrar(Produtos produtos) {
		
		String inserir = "INSERT INTO produtos "
				+ " (codigo, nome, descricao, valor, estoque) "
				+ " VALUES (?,?,?,?,?) ";
		
		try (PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, produtos.getCodigo());
			pst.setString(2, produtos.getNome());
			pst.setString(3, produtos.getDescricao());
			pst.setDouble(4, produtos.getValor());
			pst.setInt(5, produtos.getEstoque());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produtos.");
			ex.printStackTrace();
		}
	 }
		
		public void alterar(Produtos produtos) {
			
			String inserir = "UPDATE produtos "
					+ "SET nome = ?, descricao = ?, valor = ?, estoque = ? "
					+ " WHERE codigo = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				pst.setString(1, produtos.getNome());
				pst.setString(2, produtos.getDescricao());
				pst.setDouble(3, produtos.getValor());
				pst.setInt(4, produtos.getEstoque());
				pst.setInt(5, produtos.getCodigo());
				
				pst.execute();
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular " 
				        + "a tabela Produtos.");
				ex.printStackTrace();
			}
		}
     
		
		public void excluir (Produtos produtos) {
			
			String inserir = "DELETE FROM produtos "
					+ " WHERE codigo = ? ";
			
			try ( PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				pst.setInt(1, produtos.getCodigo());
				
				pst.execute();
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Produtos.");
				ex.printStackTrace();
			}
		}
		
		public Produtos consultar(int codigo) {
			
			String inserir = "SELECT * FROM produtos "
					+ " WHERE codigo = ? ";
			
			try ( PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				pst.setInt(1, codigo);
				ResultSet resultado = pst.executeQuery();
				
				Produtos p = new Produtos();
				if (resultado.next()) {
					p.setNome(resultado.getString("nome"));
					p.setValor(resultado.getDouble("valor"));
					p.setCodigo(codigo);
					p.setDescricao(resultado.getString("descricao"));
					p.setEstoque(resultado.getInt("estoque"));
				}
				return p;
				
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Produtos.");
				ex.printStackTrace();
				
				return null;
			}
		}

		
		public ArrayList<Produtos> listarProdutos() {
			
			String inserir = "SELECT * FROM produtos";
			
			try ( PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				ResultSet resultado = pst.executeQuery();
				
				ArrayList<Produtos> lista = new ArrayList<>();
				
				while (resultado.next()) {
					Produtos p = new Produtos();
					p.setNome(resultado.getString("nome"));
					p.setValor(resultado.getDouble("valor"));
					p.setCodigo(resultado.getInt("codigo"));
					p.setDescricao(resultado.getString("descricao"));
					p.setEstoque(resultado.getInt("estoque"));
					lista.add(p);
				}
				return lista;
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Produtos.");
				ex.printStackTrace();
				
				return null;
			}
		}
	}