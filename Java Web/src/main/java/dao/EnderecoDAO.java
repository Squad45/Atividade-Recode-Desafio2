package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Endereco;


public class EnderecoDAO {
private static Connection connection = ConnectionFactory.createConnection();
	
	
	public static void create(Endereco endereco) {
		String sql = "INSERT INTO endereco VALUES(null, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getEndereco());
			stmt.setString(3, endereco.getPontoRef());
			
			stmt.executeUpdate();
			System.out.println("--Correct insert on database");

			
		}catch(SQLException e) {
			System.out.println("--Incorrect insert on database "+ e.getMessage());
		}
	}
	public static void delete(int id) {
		String sql = "DELETE FROM endereco WHERE id = ?";
		try {
			PreparedStatement stmt =connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println("--correct delete on cliente");
			
		}catch(SQLException e) {
			System.out.println("--incorrect delete on cliete. " + e.getMessage());
		}
	}
	public static List<Endereco> find(String pesquisa){
		
		String sql = String.format("SELECT * FROM endereco WHERE cep like '%s%%' OR endereco LIKE '%s%%'", pesquisa, pesquisa);
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(result.getInt("id"));
				endereco.setCep(result.getString("cep"));
				endereco.setEndereco(result.getString("endereco"));
				endereco.setPontoRef(result.getString("pontoref"));
				
				
				enderecos.add(endereco);
			}
			System.out.println("--correct find enderecos");
			return enderecos;
			
		}catch(SQLException e) {
			System.out.println("--incorrect find enderecos "+ e.getMessage());
			return null;
		}
	}
	public static Endereco findByPK(int id) {
		String sql = String.format("SELECT * FROM cliente WHERE id = %d",id);
			
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			Endereco enderecos = new Endereco();
			while(result.next()) {
				enderecos.setId(result.getInt("id"));
				enderecos.setCep(result.getString("Cep"));
				enderecos.setEndereco(result.getString("endereco"));
				enderecos.setPontoRef(result.getString("pontoref"));
				
				
			}
			System.out.println("--correct find endereco");
			return enderecos; 
			
		}catch(SQLException e) {
			System.out.println("--incorrect find endereco "+ e.getMessage());
			return null;
		}
	}
	public static void update(Endereco enderecos) {
		String sql = "UPDATE cliente SET cep=?, endereco=?, pontoref=?, WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, enderecos.getCep());
			stmt.setString(2, enderecos.getEndereco());
			stmt.setString(3, enderecos.getPontoRef());
			stmt.setInt(5, enderecos.getId());
			
			stmt.executeUpdate();
			System.out.println("--Correct update on database");

			
		}catch(SQLException e) {
			System.out.println("--Incorrect update on database "+ e.getMessage());
		
		}
	}
}
