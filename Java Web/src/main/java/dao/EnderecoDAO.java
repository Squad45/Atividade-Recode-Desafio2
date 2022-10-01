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
				Endereco cli = new Endereco();
				cli.setId(result.getInt("id"));
				cli.setNome(result.getString("nome"));
				cli.setCpf(result.getString("cpf"));
				cli.setNascimento(result.getString("nascimento"));
				cli.setSituacao(result.getString("situacao"));
				
				clientes.add(cli);
			}
			System.out.println("--correct find clientes");
			return clientes;
			
		}catch(SQLException e) {
			System.out.println("--incorrect find clientes "+ e.getMessage());
			return null;
		}
	}
	public static Cliente findByPK(int id) {
		String sql = String.format("SELECT * FROM cliente WHERE id = %d",id);
			
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			Cliente cli = new Cliente();
			while(result.next()) {
				cli.setId(result.getInt("id"));
				cli.setNome(result.getString("nome"));
				cli.setCpf(result.getString("cpf"));
				cli.setNascimento(result.getString("nascimento"));
				cli.setSituacao(result.getString("situacao"));
				
			}
			System.out.println("--correct find cliente");
			return cli; 
			
		}catch(SQLException e) {
			System.out.println("--incorrect find cliente "+ e.getMessage());
			return null;
		}
	}
	public static void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nome=?, cpf=?, nascimento=?, situacao=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getNascimento());
			stmt.setString(4, cliente.getSituacao());
			stmt.setInt(5, cliente.getId());
			
			stmt.executeUpdate();
			System.out.println("--Correct update on database");

			
		}catch(SQLException e) {
			System.out.println("--Incorrect update on database "+ e.getMessage());
		
	}
}
