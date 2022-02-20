package avaliacao2.questao09;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection con = null;
	
	public static Connection getConnection () {
		if (con == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				con = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}		
		return con;		
	}
	
	public static void closeConnection () {
		if (con != null) {
			try {
				con.close(); 
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
		private static Properties loadProperties () {												//Método para carregar as infomações definidas do arquivo db.propeties
			try (FileInputStream f =  new FileInputStream("db.propeties")) {
				Properties props = new Properties();
				props.load(f);																		//(Leitura do arquivo propeties e guarda os dados dentro do obejto props)
				return props;			
			}
			catch (IOException e) {
				throw new DbException(e.getMessage());
		}
	}
}


