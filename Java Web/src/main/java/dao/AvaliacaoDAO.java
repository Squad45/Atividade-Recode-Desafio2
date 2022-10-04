package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionFactory.ConnectionFactory;

public class AvaliacaoDAO {
	private static Connection connection = ConnectionFactory.createConnection();
	private static String sql;
	
	public static void adicionarParaAvalicao(int id) {
		sql = "INSERT INTO avaliacao (fk_codCad) VALUE(?)";
		try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, id);
			 
			 preparedStatement.executeUpdate();
			 System.out.println("cliente está em avaliação");
		}catch(SQLException e) {
			System.out.println("Não foi possível por em avaliação "+ e.getMessage());
		}
	}
	public static void atualizarAvaliacaoSIM(int id) {
		sql = "UPDATE avaliacao set avaliacao = \"SIM\" where fk_codCad = ?;";
		try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, id);
			 
			 preparedStatement.executeUpdate();
			 System.out.println("cliente aceito");
		}catch(SQLException e) {
			System.out.println("Não foi possível avaliar "+ e.getMessage());
		}
	}
	public static void atualizarAvaliacaoNAO(int id) {
		sql = "UPDATE avaliacao set avaliacao = \"NAO\" where fk_codCad = ?;";
		try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, id);
			 
			 preparedStatement.executeUpdate();
			 System.out.println("cliente negado");
		}catch(SQLException e) {
			System.out.println("Não foi possível avaliar "+ e.getMessage());
		}
	}
	
}
