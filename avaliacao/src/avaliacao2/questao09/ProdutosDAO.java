package avaliacao2.questao09;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

	private Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}

	public void Salvar(Produtos produto) {
		String sql = "INSERT INTO tblproduto (nome , descricao ,desconto, data) VALUES (?,?,?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getDesconto());
			pstm.setDate(4, Date.valueOf(java.time.LocalDate.now()));

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Produtos> listar() throws SQLException {
		List<Produtos> produtos = new ArrayList<Produtos>();
		String sql = "SELECT * FROM tblproduto";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			pstm.execute();

			try (ResultSet rst = pstm.getResultSet();) {
				while (rst.next()) {
					Produtos produto = new Produtos(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),
							rst.getDate(5));
					produtos.add(produto);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return produtos;
	}

	public List<Produtos> listebusca(String n) {
		List<Produtos> produtos = new ArrayList<Produtos>();
		String sql = "SELECT * FROM tblproduto WHERE NOME LIKE ? ";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			pstm.setString(1, '%' + n + '%');
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet();) {
				while (rst.next()) {
					Produtos produto = new Produtos(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),
							rst.getDate(5));
					produtos.add(produto);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return produtos;
	}

	public void delete(Integer id) {
		String sql = "DELETE FROM tblproduto WHERE ID = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			pstm.setInt(1, id);
			pstm.executeUpdate();

			Integer LinhasAfetadas = pstm.getUpdateCount();

			System.out.println("Registros deletados nº= " + LinhasAfetadas);

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void alterar(String nome, String descricao, double desconto, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE tblproduto  SET NOME = ?, DESCRICAO = ?, DESCONTO = ? WHERE ID = ?")) {
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.setDouble(3, desconto);
			stm.setInt(4, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public Produtos findById(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM tblproduto WHERE ID= ?")) {
			stm.setInt(1, id);
			stm.execute();
			try (ResultSet rst = stm.getResultSet();) {
				while (rst.next()) {
					Produtos produto = new Produtos(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),
							rst.getDate(5));
					return produto;
				}
				return null;
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public boolean existId(Integer id) {
		String sql = "SELECT ID FROM tblproduto WHERE ID = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet();) {
				if (rst.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
