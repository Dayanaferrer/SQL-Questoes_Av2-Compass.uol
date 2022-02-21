package avaliacao2.questao09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
//import java.text.SimpleDateFormat;

public class ProgramInserir {

	public static void main(String[] args) {
		
//		SimpleDateFormat data = new SimpleDateFormat("yyy-MM-dd");
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DB.getConnection();
			
			stmt = con.prepareStatement("INSERT INTO tblproduto"
									+ "(nome, descricao, desconto)"
									+ "VALUES"
									+"(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, "Periférico");
			stmt.setString(2, "Mesa digitalizadora");
			stmt.setDouble(3, 0.75);
//			stmt.setDate(4, new java.sql.Date(data.parse("20222-02-20").getTime()));
			
			int rowsAffected = stmt.executeUpdate ();
			
			if (rowsAffected > 0) {
				
				ResultSet r = stmt.getGeneratedKeys();
				while(r.next()) {
					int id = r.getInt (1);
					System.out.println("Id= " +id);
				}
			}
			else {
				System.out.println("Nenhuma Linha foi alterada!");
			}
			
		}
		catch(SQLException e) {
			System.out.println("erro SQLEx: " + e);
		}
		finally {
			
			DB.closeConnection();
		}
	}

}
