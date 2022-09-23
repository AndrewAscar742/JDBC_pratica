package jdbc_pratica.alura.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import jdbc_pratica.alura.connection.CriarConexao;

public class JDBC_Adicionar_PreStm {
	
	public static void main(String[] args) throws SQLException {
		CriarConexao conexao = new CriarConexao();
		Connection conn = conexao.recriarConexao();
		Scanner scText = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in).useLocale(Locale.US);
		
		//Variáveis primitivos
		String nome = scText.nextLine();
		String cpf = scText.nextLine();
		String cargo = scText.nextLine();
		double salario = scDouble.nextDouble();
		
		//Aqui ele prepara o Statement, evitando SQL Injection (Evitando concatenação e possíveis ataques)
		PreparedStatement stm = conn.prepareStatement("INSERT INTO tb_funcionario VALUES (?, ?, ?, ?)");
		
		stm.setString(1, nome);
		stm.setString(2, cpf);
		stm.setString(3, cargo);
		stm.setDouble(4, salario);
		
		stm.execute();
		
		System.out.println(stm.getUpdateCount());
		
		//Encerramento das instâncias
		scText.close();
		scDouble.close();
		stm.close();
		conn.close();
	}
}
