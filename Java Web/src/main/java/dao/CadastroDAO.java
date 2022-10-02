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
import model.Endereco;


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
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cadastro cadastro = new Cadastro();
				
				
				cadastro.setId(resultSet.getInt("id"));
				cadastro.setEscolha(resultSet.getString("escolha"));
				cadastro.setNome(resultSet.getString("nome"));
				cadastro.setEmail(resultSet.getString("Email"));
				cadastro.setCpf(resultSet.getString("Cpf"));
				Endereco endereco = new Endereco();
				cadastro.setEndereco(endereco);
				cadastro.getEndereco().setId(resultSet.getInt("endereco"));
				cadastro.setTelefone(resultSet.getString("Telefone"));
				cadastro.setOpcaoDoador(resultSet.getString("OpcaoDoador"));
				cadastro.setTipoEquipamento(resultSet.getString("TipoEquipamento"));
				cadastro.setDescricao(resultSet.getString("descricao"));
				
				cadastros.add(cadastro);
				
			}
			
			System.out.println("Encontrado com sucesso");
			return cadastros;
			
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Cadastro findByPk(int cadastroId) {
		sql = String.format("SELECT * FROM clientes WHERE id = %d ", cadastroId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cadastro cadastro = new Cadastro();
			
			while (resultSet.next()) {
				cadastro.setId(resultSet.getInt("id"));
				cadastro.setEscolha(resultSet.getString("escolha"));
				cadastro.setNome(resultSet.getString("nome"));
				cadastro.setEmail(resultSet.getString("email"));
				cadastro.setCpf(resultSet.getString("cpf"));
				Endereco endereco = new Endereco();
				cadastro.setEndereco(endereco);
				cadastro.getEndereco().setId(resultSet.getInt("endereco"));
				cadastro.setTelefone(resultSet.getString("telefone"));
				cadastro.setOpcaoDoador(resultSet.getString("opcaodoador"));
				cadastro.setTipoEquipamento(resultSet.getString("tipoequipamento"));
				cadastro.setDescricao(resultSet.getString("descricao"));
			}
			
			System.out.println("Encontrado corretamente por pk clientes");
			return cadastro;
			
	} catch(SQLException e) {
		
			System.out.println("Nao encontrado corretamente pro  pk clientes. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Cadastro cadastro) {
		sql = "UPDATE clientes SET escolha=?, nome=?, email=?, cpf=?, =?, telefone=?, opcaodoador=?, tipoequipamento=?, descricao=?, WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cadastro.getEscolha());
			 preparedStatement.setString(2, cadastro.getNome());
			 preparedStatement.setString(3, cadastro.getEmail());
			 preparedStatement.setString(4, cadastro.getCpf());
			 
			 //Endereco
			 preparedStatement.setString(5, cadastro.getTelefone());
			 preparedStatement.setString(6, cadastro.getOpcaoDoador());
			 preparedStatement.setString(7, cadastro.getTipoEquipamento());
			 preparedStatement.setString(8, cadastro.getDescricao());
			 preparedStatement.setString(4, cadastro.getCpf());
			 preparedStatement.setInt(5, cadastro.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("Atualizado com sucesso");
			 
		 } catch(SQLException e) {
			 System.out.println("Erro ao atualizar. " + e.getMessage());
		 }
	}
}


