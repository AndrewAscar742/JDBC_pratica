package jdbc_pratica.alura.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc_pratica.alura.connection.CriarConexao;

public class JDBC_Remover {

	public static void main(String[] args) throws SQLException {
			CriarConexao conexao = new CriarConexao();
			Connection conn = conexao.recriarConexao();
			String nome = "Felipe Melo";
			
			PreparedStatement stm = conn.prepareStatement("DELETE FROM tb_funcionario WHERE nome == ?");
			stm.setString(1, nome);
			stm.execute();
			
			//Obtem Quantas linhas foi apagada
			int linhasApagada = stm.getUpdateCount();
			System.out.println(linhasApagada);
			
			conn.close();
			stm.close();
	}

}
