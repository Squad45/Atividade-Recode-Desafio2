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
	

	public static void createJuridica(Cadastro cadastro) {
	
	//necessário ver mais sobre if e case no mysql para o futuro do projeto
		if(cadastro.getOpcaoDoador().equals("Beneficiario")) {
			sql = "INSERT INTO cadastro(codCad, escolha, nome, cnpj, cargo, endereco, nomeInstituicao, email, telefone, opcaoDoador, tipoEquipamento, descricao) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?)";
		
			try {
				 PreparedStatement preparedStatement = connection.prepareStatement(sql);
				 
				 
				 preparedStatement.setString(1, cadastro.getEscolha());
				 preparedStatement.setString(2, cadastro.getNome());
				 preparedStatement.setString(3, cadastro.getCnpj());
				 preparedStatement.setString(4, cadastro.getCargo());
				 preparedStatement.setInt(5, cadastro.getEndereco().getId());
				 preparedStatement.setString(6, cadastro.getNomeInstituicao());
				 preparedStatement.setString(7, cadastro.getEmail());
				 preparedStatement.setString(8, cadastro.getTelefone());
				 preparedStatement.setString(9, cadastro.getOpcaoDoador());
				 preparedStatement.setString(10, cadastro.getDescricao());
				 
				 preparedStatement.executeUpdate();
				 
				 System.out.println("Beneficiario inserido com sucesso");
				 
			 } catch(SQLException e) {
				 System.out.println("Nao inserido, tente novamente. " + e.getMessage());
			 }
		}else if(cadastro.getOpcaoDoador().equals("Doador")){
			sql = "INSERT INTO cadastro(codCad, escolha, nome, cnpj, cargo, endereco, nomeInstituicao, email, telefone, opcaoDoador, tipoEquipamento, descricao) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
			try {
				 PreparedStatement preparedStatement = connection.prepareStatement(sql);
				 
				 
				 preparedStatement.setString(1, cadastro.getEscolha());
				 preparedStatement.setString(2, cadastro.getNome());
				 preparedStatement.setString(3, cadastro.getCnpj());
				 preparedStatement.setString(4, cadastro.getCargo());
				 preparedStatement.setInt(5, cadastro.getEndereco().getId());
				 preparedStatement.setString(6, cadastro.getNomeInstituicao());
				 preparedStatement.setString(7, cadastro.getEmail());
				 preparedStatement.setString(8, cadastro.getTelefone());
				 preparedStatement.setString(9, cadastro.getOpcaoDoador());
				 preparedStatement.setString(10, cadastro.getTipoEquipamento());
				 preparedStatement.setString(11, cadastro.getDescricao());
				 
				 preparedStatement.executeUpdate();
				 
				 System.out.println("Inserido com sucesso");
				 
			 } catch(SQLException e) {
				 System.out.println("Nao inserido, tente novamente. " + e.getMessage());
			 }
		}else {
			System.out.println("ouve um erro de escolha");
		}
}


	public static void createFisica(Cadastro cadastro) {
		
		//necessário ver mais sobre if e case no mysql para o futuro do projeto
		if(cadastro.getOpcaoDoador().equals("Beneficiario")) {
			sql = "INSERT INTO cadastro(codCad, escolha, nome, cpf, endereco, email, telefone, opcaoDoador, tipoEquipamento, descricao) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, NULL, ?)";
			
			try {
				 PreparedStatement preparedStatement = connection.prepareStatement(sql);
				 
				 
				 preparedStatement.setString(1, cadastro.getEscolha());
				 preparedStatement.setString(2, cadastro.getNome());
				 preparedStatement.setString(3, cadastro.getCpf());
				 preparedStatement.setInt(4, cadastro.getEndereco().getId());
				 preparedStatement.setString(5, cadastro.getEmail());
				 preparedStatement.setString(6, cadastro.getTelefone());
				 preparedStatement.setString(7, cadastro.getOpcaoDoador());
				 preparedStatement.setString(8, cadastro.getDescricao());
				 
				 preparedStatement.executeUpdate();
				 
				 System.out.println("Inserido com sucesso");
				 
			 } catch(SQLException e) {
				 System.out.println("Nao inserido, tente novamente. " + e.getMessage());
			 }
		}else if(cadastro.getOpcaoDoador().equals("Doador")){
			sql = "INSERT INTO cadastro(codCad, escolha, nome, cpf, endereco, email, telefone, opcaoDoador, tipoEquipamento, descricao) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
			try {
				 PreparedStatement preparedStatement = connection.prepareStatement(sql);
				 
				 
				 preparedStatement.setString(1, cadastro.getEscolha());
				 preparedStatement.setString(2, cadastro.getNome());
				 preparedStatement.setString(3, cadastro.getCpf());
				 preparedStatement.setInt(4, cadastro.getEndereco().getId());
				 preparedStatement.setString(5, cadastro.getEmail());
				 preparedStatement.setString(6, cadastro.getTelefone());
				 preparedStatement.setString(7, cadastro.getOpcaoDoador());
				 preparedStatement.setString(8, cadastro.getTipoEquipamento());
				 preparedStatement.setString(9, cadastro.getDescricao());
				 
				 preparedStatement.executeUpdate();
				 
				 System.out.println("Inserido com sucesso");
				 
			 } catch(SQLException e) {
				 System.out.println("Nao inserido, tente novamente. " + e.getMessage());
			 }
		}else {
			System.out.println("ocorreu um erro na escolha");
		}
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM cadastro WHERE codCad = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("Deletado com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar. " + e.getMessage());
		}
	}
	
	public static List<Cadastro> findFisica(){
		
		sql = "SELECT codCad, escolha, nome, cpf, endereco, email, telefone, opcaoDoador, tipoEquipamento, descricao  FROM cadastro";
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cadastro cadastro = new Cadastro();
				
				
				cadastro.setId(resultSet.getInt("codCad"));
				cadastro.setEscolha(resultSet.getString("escolha"));
				cadastro.setNome(resultSet.getString("nome"));
				cadastro.setCpf(resultSet.getString("cpf"));
				Endereco endereco = new Endereco();
				cadastro.setEndereco(endereco);
				cadastro.getEndereco().setId(resultSet.getInt("endereco"));
				cadastro.setEmail(resultSet.getString("email"));
				cadastro.setTelefone(resultSet.getString("telefone"));
				cadastro.setOpcaoDoador(resultSet.getString("opcaoDoador"));
				//observar se isso funciona
				cadastro.setTipoEquipamento(resultSet.getString("tipoEquipamento"));
				cadastro.setDescricao(resultSet.getString("descricao"));
				
				cadastros.add(cadastro);
				
			}
			
			System.out.println("clientes encontrados");
			return cadastros;
			
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar. " + e.getMessage());
			return null;
		}
		
		
	}
	
public static List<Cadastro> findJuridica(){
		
		sql = "SELECT codCad, codCad, escolha, nome, cnpj, cargo, endereco, nomeInstituicao, email, telefone, opcaoDoador, tipoEquipamento, descricao  FROM cadastro";
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cadastro cadastro = new Cadastro();
				
				
				cadastro.setId(resultSet.getInt("codCad"));
				cadastro.setEscolha(resultSet.getString("escolha"));
				cadastro.setNome(resultSet.getString("nome"));
				cadastro.setCnpj(resultSet.getString("cnpj"));
				cadastro.setCargo(resultSet.getString("cargo"));
				Endereco endereco = new Endereco();
				cadastro.setEndereco(endereco);
				cadastro.getEndereco().setId(resultSet.getInt("endereco"));
				cadastro.setNomeInstituicao(resultSet.getString("nomeInstituicao"));
				cadastro.setEmail(resultSet.getString("email"));
				cadastro.setTelefone(resultSet.getString("telefone"));
				cadastro.setOpcaoDoador(resultSet.getString("opcaoDoador"));
				//observar se isso funciona
				cadastro.setTipoEquipamento(resultSet.getString("tipoEquipamento"));
				cadastro.setDescricao(resultSet.getString("descricao"));
				
				cadastros.add(cadastro);
				
			}
			
			System.out.println("clientes encontrados");
			return cadastros;
			
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Cadastro findByPk(int cadastroId) {
		sql = "SELECT * FROM cadastro WHERE codCad ="+ cadastroId;
		
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
				cadastro.setDescricao(resultSet.getString("descricao"));
			}
			
			System.out.println("Encontrado corretamente por pk clientes");
			return cadastro;
			
	} catch(SQLException e) {
		
			System.out.println("Nao encontrado corretamente pro  pk clientes. " + e.getMessage());
			return null;
		}
	}
	
	public static void updateFisica(Cadastro cadastro) {
		sql = "UPDATE clientes SET escolha=?, nome=?, cpf=?, endereco=?, email=?, telefone=?, opcaodoador=?, tipoequipamento=?, descricao=?, WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cadastro.getEscolha());
			 preparedStatement.setString(2, cadastro.getNome());
			 preparedStatement.setString(3, cadastro.getCpf());
			 preparedStatement.setInt(4, cadastro.getEndereco().getId());
			 preparedStatement.setString(5, cadastro.getEmail());
			 preparedStatement.setString(6, cadastro.getTelefone());
			 preparedStatement.setString(7, cadastro.getOpcaoDoador());
			 preparedStatement.setString(8, cadastro.getTipoEquipamento());
			 preparedStatement.setString(9, cadastro.getDescricao());
			 preparedStatement.setInt(10, cadastro.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("Atualizado com sucesso");
			 
		 } catch(SQLException e) {
			 System.out.println("Erro ao atualizar. " + e.getMessage());
		 }
	}
	
	public static void pegarID(Cadastro cadastro) {
		 String sql = "SELECT codCad FROM cadastro WHERE cpf="+cadastro.getCpf();
		 ResultSet resultado = null;
		 try {
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 resultado = stmt.executeQuery(sql);
			 
			 if(resultado.next()) {
				 cadastro.setId(resultado.getInt("codCad"));
			 }
			 System.out.println("id encontrado");
		 }catch (SQLException e) {
			 System.out.println("houve um erro ao pegar o id" + e.getMessage());
		 }
	}
}


