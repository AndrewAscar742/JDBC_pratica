package jdbc_pratica.alura.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_pratica.alura.connection.CriarConexao;

public class JDBC_Adicionar {
	
	public static void main(String[] args) throws SQLException {
		CriarConexao conector = new CriarConexao();
		Connection conn = conector.recriarConexao();
		
		Statement stm = conn.createStatement();
		stm.execute("INSERT INTO tb_funcionario VALUES('Guts', '12345678911', 'Programador Junior', '3450.50')",
				Statement.RETURN_GENERATED_KEYS);
		
		//
		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			int id = rst.getInt(1);
			System.out.println("O id que foi gerado ao adicionar foi: " + id);
		}
	}

}
