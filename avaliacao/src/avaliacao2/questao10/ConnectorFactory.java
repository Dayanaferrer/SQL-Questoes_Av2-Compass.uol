package avaliacao2.questao10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectorFactory {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/funcionario?useTimezone=true&serverTimezone=UTC"; 
	private static final String USER ="root";
	private static final String PASS = "root123!";
	
	public static Connection getConnection () {		
		try {
			Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USER, PASS);						
		} catch (ClassNotFoundException  | SQLException ex) {
			throw new RuntimeException("Erro na conexão:  ", ex);					
		}
	
	}		
	public static void closeConnection(Connection con) {		//Fechar conexão(SEMPRE).		 
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println("Mensagem do erro: " + ex);				
			}			
		}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {	//Fechar Prepared Statement também.		 
		closeConnection(con);
		
		try {	
			if (stmt != null) {
				stmt.close();			
			}
			
		} catch (SQLException ex) {
			System.out.println("Mensagem do erro Prepared Statement: " + ex);
			
		}
		
	}
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {	//Fechar Prepared Statement também.		 
		closeConnection(con, stmt);
		
		try {	
			if (rs != null) {
				rs.close();			
			}
			
		} catch (SQLException ex) {
			System.out.println("Mensagem do erro ResultSet: " + ex);
			
		}
		
	}
	

	
	}
	
	
