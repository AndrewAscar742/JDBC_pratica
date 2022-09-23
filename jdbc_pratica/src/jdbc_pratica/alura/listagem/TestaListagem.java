package jdbc_pratica.alura.listagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_pratica.alura.connection.CriarConexao;

public class TestaListagem {

	public static void main(String[] args) {
		CriarConexao conexao = new CriarConexao();
		Connection connection;
		
		String url = "jdbc:mysql://localhost/LOJA?useTimezone=true&serverTimezone=UTC";
		
		try {
			connection = conexao.recriarConexao();
			
			//Ele é o cara responsável por executar os comandos
			Statement stm = connection.createStatement();
			
			//Validação se existe a tabela
			boolean validarTabela = stm.execute("SELECT * FROM tb_funcionario");
			
			//eu consigo pegar todo o conteúdo dos meus produtos adicionados à minha tabela
			ResultSet result = stm.getResultSet();
			
			while (result.next()) {
				String nome = result.getString("nome");
				String cpf = result.getString("cpf");
				String cargo = result.getString("cargo");
				float sal = result.getFloat("salario");
				System.out.println("[" + nome + " " + cpf + " " + cargo + " " + sal + "]");
				
			}
			
			//Ele fecha a conexão, SEMPRE É RECOMENDADO
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
