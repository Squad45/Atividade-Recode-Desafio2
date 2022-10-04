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
		String sql = "INSERT INTO endereco VALUES(null, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getEndereco());
			stmt.setString(3, endereco.getPontoRef());
			stmt.setString(4, endereco.getUf());
			
			stmt.executeUpdate();
			System.out.println("--Correct insert on database");

			
		}catch(SQLException e) {
			System.out.println("--Incorrect insert on database "+ e.getMessage());
		}
	}
	public static void delete(int id) {
		String sql = "DELETE FROM endereco WHERE codEndereco = ?";
		try {
			PreparedStatement stmt =connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println("endereço deletado com sucesso");
			
		}catch(SQLException e) {
			System.out.println("houve um erro ao deletar o endereço " + e.getMessage());
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
				endereco.setUf(result.getString("uf"));
				
				
				enderecos.add(endereco);
			}
			System.out.println("enderecos encontrados");
			return enderecos;
			
		}catch(SQLException e) {
			System.out.println("--houve um erro ao tentar encontrar os endereços "+ e.getMessage());
			return null;
		}
	}
	public static Endereco findByPK(int id) {
		String sql = String.format("SELECT * FROM endereco WHERE codEndereco = %d",id);
			
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			Endereco enderecos = new Endereco();
			while(result.next()) {
				enderecos.setId(result.getInt("id"));
				enderecos.setCep(result.getString("Cep"));
				enderecos.setEndereco(result.getString("endereco"));
				enderecos.setPontoRef(result.getString("pontoref"));
				enderecos.setUf(result.getString("uf"));
				
				
			}
			System.out.println("Endereço encontrado");
			return enderecos; 
			
		}catch(SQLException e) {
			System.out.println("houve um erro ao tentar encontrar o endereço"+ e.getMessage());
			return null;
		}
	}
	public static void update(Endereco enderecos) {
		String sql = "UPDATE endereco SET cep=?, endereco=?, pontoref=?, uf=? WHERE codEndereco=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, enderecos.getCep());
			stmt.setString(2, enderecos.getEndereco());
			stmt.setString(3, enderecos.getPontoRef());
			stmt.setString(4, enderecos.getUf());
			stmt.setInt(5, enderecos.getId());
			
			stmt.executeUpdate();
			System.out.println("endereço atualizado");

			
		}catch(SQLException e) {
			System.out.println("erro ao tentar atualizar esse endereço "+ e.getMessage());
		
		}
	}
	public static void pegarID(Endereco endereco) {
		 //PEGANDO O ID PARA PODER FAZER O METODO fazerRelacao()
		 String sql = "SELECT codEndereco FROM endereco WHERE cep="+endereco.getCep();
		 ResultSet resultado = null;
		 try {
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 resultado = stmt.executeQuery(sql);
			 
			 if(resultado.next()) {
				 endereco.setId(resultado.getInt(1));
			 }
			 System.out.println("id pego com sucesso" + endereco.getId());
		 }catch (SQLException e) {
			 System.out.println("não foi possivel pegar o id "+ e.getMessage());
		 }
	 }
}
