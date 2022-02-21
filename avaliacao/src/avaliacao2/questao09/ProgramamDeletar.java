package avaliacao2.questao09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramamDeletar {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DB.getConnection();
			
			stmt = con.prepareStatement("DELETE FROM tblproduto WHERE id=?");																	
			stmt.setInt(1, 16);
			
			int rowsAffected = stmt.executeUpdate ();
			
			System.out.println("Linhas afetadas: " + rowsAffected);		
		}
		catch(SQLException e) {
			System.out.println("erro SQLEx: " + e);
		}
		finally {	
			DB.closeConnection();
		}
	}

	}


