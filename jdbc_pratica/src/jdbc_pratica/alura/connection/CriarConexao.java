package jdbc_pratica.alura.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {

	public Connection recriarConexao() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost/LOJA?useTimezone=true&serverTimezone=UTC";
		
		try {
			connection = DriverManager.getConnection(url, "root", "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
		
	}

}
