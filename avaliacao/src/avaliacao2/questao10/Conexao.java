package avaliacao2.questao10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	public static void main(String[] args) throws SQLException {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conexao = DriverManager.getConnection(null, null, null);
			
			
		} catch (ClassNotFoundException ex) {
			
			System.out.println("Driver do banco de dados não localizado! ");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao acessar o banco" + ex.getMessage());
		} finally {
			if (conexao != null) {
				conexao.close();
			}
			
		}

	}

}
