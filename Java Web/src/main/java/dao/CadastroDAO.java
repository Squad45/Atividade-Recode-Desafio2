package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Cadastro;


public class CadastroDAO {
	private static Connection connection = ConnectionFactory.createConnection();
private static String sql;
	
	public static void createFisica(Cadastro cadastro) {
		 sql = "INSERT INTO cadastro VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 
			 preparedStatement.setString(1, cadastro.getEscolha());
			 preparedStatement.setString(2, cadastro.getNome());
			 preparedStatement.setString(3, cadastro.getEmail());
			 preparedStatement.setString(4, cadastro.getCpf());
			 preparedStatement.setInt(5, cadastro.getEndereco().getId());
			 preparedStatement.setString(6, cadastro.getTelefone());
			 preparedStatement.setString(7, cadastro.getOpcaoDoador());
			 preparedStatement.setString(8, cadastro.getTipoEquipamento());
			 preparedStatement.setString(9, cadastro.getDescricao());
			 preparedStatement.setInt(10, cadastro.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("Inserido com sucesso");
			 
		 } catch(SQLException e) {
			 System.out.println("Nao inserido, tente novamente. " + e.getMessage());
		 }
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("Deletado com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar. " + e.getMessage());
		}
	}
	
	public static List<Cadastro> find(String pesquisa){
		
		sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cadastro> clientes = new ArrayList<Cadastro>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cadastro cliente = new Cadastro();
				
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				clientes.add(cliente);
				
			}
			
			System.out.println("Encontrado com sucesso");
			return clientes;
			
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM clientes WHERE id = %d ", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
			}
			
			System.out.println("Encontrado corretamente por pk clientes");
			return cliente;
			
	} catch(SQLException e) {
		
			System.out.println("Nao encontrado corretamente pro  pk clientes. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, nascimento=?, situacao=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cliente.getNome());
			 preparedStatement.setString(2, cliente.getCpf());
			 preparedStatement.setString(3, cliente.getNascimento());
			 preparedStatement.setString(4, cliente.getSituacao());
			 preparedStatement.setInt(5, cliente.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("Atualizado com sucesso");
			 
		 } catch(SQLException e) {
			 System.out.println("Erro ao atualizar. " + e.getMessage());
		 }
	}
}

}
