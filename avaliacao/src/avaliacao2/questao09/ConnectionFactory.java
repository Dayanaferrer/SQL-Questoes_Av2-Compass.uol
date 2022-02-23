package avaliacao2.questao09;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/prdotuo?userTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root123!");

		comboPooledDataSource.setMaxPoolSize(15);
		;

		this.dataSource = comboPooledDataSource;
	}

	public Connection createConnection()  {
		try {
			return this.dataSource.getConnection();
		}catch(SQLException e) {

			throw new RuntimeException(e);
		}
	}


}
