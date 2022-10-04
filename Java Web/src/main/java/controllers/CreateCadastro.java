package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AvaliacaoDAO;
import dao.CadastroDAO;
import dao.EnderecoDAO;
import model.Cadastro;
import model.Endereco;

/**
 * Servlet implementation class CreateCadastro
 */
@WebServlet({ "/criandoCadastro", "/pessoaFisica", "/pessoaJuridica", "/doadorJuridico", "/beneficiarioJuridico", "/doadorFisico", "/beneficiarioFisico", "/fimCadastroDoador", "/fimCadastroBeneficiario"})
public class CreateCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//talvez tenha sido melhor criar um servlet pra cada tipo de cliente
	Cadastro cliente = new Cadastro();
	Endereco endereco = new Endereco();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getServletPath();
		
		if(action.equals("/pessoaJuridica")) {
			System.out.println("enviando para cadastro juridico");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro2_empresa.html");
			requestDispatcher.forward(request, response);
			
			
		}else if(action.equals("/pessoaFisica")) {
			System.out.println("enviando para cadastro fisico");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro3_pessoa.html");
			requestDispatcher.forward(request, response);
			
			
		}else if(action.equals("/doadorJuridico") || action.equals("/doadorFisico")) {
			System.out.println("enviando para o fim do cadastro doador");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro_doacao.html");
			requestDispatcher.forward(request, response);
			
			
		}else if(action.equals("/beneficiarioJuridico") || action.equals("/beneficiarioFisico")) {
			System.out.println("enviando para o fim do cadastro beneficiario");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro_preciso.html");
			requestDispatcher.forward(request, response);
			
			
		}else if(action.equals("/fimCadastroDoador") || action.equals("/fimCadastroBeneficiario")) {
			System.out.println("cadastro feito");
			request.setAttribute("cliente", cliente);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("sucessojsp.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getServletPath();
		if(action.equals("/pessoaJuridica")) {
			cliente.setEscolha("Juridica");
			System.out.println(cliente.getEscolha());
			
			
		}else if(action.equals("/pessoaFisica")) {
			cliente.setEscolha("Fisica");
			System.out.println(cliente.getEscolha());
			
			
		}else if(action.equals("/doadorJuridico")) {
			cliente.setNome(request.getParameter("nome"));
			cliente.setCargo(request.getParameter("cargo"));
			cliente.setNomeInstituicao(request.getParameter("nomeEmp"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelefone(request.getParameter("telefone"));
			cliente.setCnpj(request.getParameter("cnpj"));
			cliente.setEndereco(endereco);
			cliente.getEndereco().setCep(request.getParameter("cep"));
			cliente.getEndereco().setUf(request.getParameter("uf"));
			cliente.getEndereco().setEndereco(request.getParameter("endereco"));
			cliente.getEndereco().setPontoRef(request.getParameter("pontoRef"));
			cliente.setOpcaoDoador("Doador");
			System.out.println(cliente.getNome());
			
			
		}else if(action.equals("/beneficiarioJuridico")) {
			cliente.setNome(request.getParameter("nome"));
			cliente.setCargo(request.getParameter("cargo"));
			cliente.setNomeInstituicao(request.getParameter("nomeEmp"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelefone(request.getParameter("telefone"));
			cliente.setCnpj(request.getParameter("cnpj"));
			
			cliente.setEndereco(endereco);
			cliente.getEndereco().setCep(request.getParameter("cep"));
			cliente.getEndereco().setUf(request.getParameter("uf"));
			cliente.getEndereco().setEndereco(request.getParameter("endereco"));
			cliente.getEndereco().setPontoRef(request.getParameter("pontoRef"));
			cliente.setOpcaoDoador("Beneficiario");
			System.out.println(cliente.getNome());
			
			
			
		}else if(action.equals("/doadorFisico")) {
			cliente.setNome(request.getParameter("nome"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelefone(request.getParameter("telefone"));
			cliente.setCpf(request.getParameter("cpf"));
			
			cliente.setEndereco(endereco);
			cliente.getEndereco().setCep(request.getParameter("cep"));
			cliente.getEndereco().setUf(request.getParameter("uf"));
			cliente.getEndereco().setEndereco(request.getParameter("endereco"));
			cliente.getEndereco().setPontoRef(request.getParameter("pontoRef"));
			cliente.setOpcaoDoador("Doador");
			System.out.println(cliente.getNome());
			
			
		}else if(action.equals("/beneficiarioFisico")) {
			cliente.setNome(request.getParameter("nome"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelefone(request.getParameter("telefone"));
			cliente.setCpf(request.getParameter("cpf"));
			
			cliente.setEndereco(endereco);
			cliente.getEndereco().setCep(request.getParameter("cep"));
			cliente.getEndereco().setUf(request.getParameter("uf"));
			cliente.getEndereco().setEndereco(request.getParameter("endereco"));
			cliente.getEndereco().setPontoRef(request.getParameter("pontoRef"));
			cliente.setOpcaoDoador("Doador");
			System.out.println(cliente.getNome());
			
			
		}else if(action.equals("/fimCadastroDoador") && cliente.getEscolha().equals("Juridica")) {
			cliente.setTipoEquipamento(request.getParameter("equipamento"));
			cliente.setDescricao(request.getParameter("explicacao"));
			
			
			EnderecoDAO.create(cliente.getEndereco());
			EnderecoDAO.pegarID(cliente.getEndereco());
			CadastroDAO.createJuridica(cliente);
			CadastroDAO.pegarID(cliente);
			int id = cliente.getId();
			AvaliacaoDAO.adicionarParaAvalicao(id);
			
			
		}else if(action.equals("/fimCadastroBeneficiario") && cliente.getEscolha().equals("Juridica")) {
			cliente.setDescricao(request.getParameter("explicacao"));
			
			
			EnderecoDAO.create(cliente.getEndereco());
			EnderecoDAO.pegarID(cliente.getEndereco());
			CadastroDAO.createJuridica(cliente);
			CadastroDAO.pegarID(cliente);
			int id = cliente.getId();
			AvaliacaoDAO.adicionarParaAvalicao(id);
			
			
		}else if(action.equals("/fimCadastroDoador") && cliente.getEscolha().equals("Fisica")) {
			cliente.setTipoEquipamento(request.getParameter("equipamento"));
			cliente.setDescricao(request.getParameter("explicacao"));
			
			
			EnderecoDAO.create(cliente.getEndereco());
			EnderecoDAO.pegarID(cliente.getEndereco());
			CadastroDAO.createFisica(cliente);
			CadastroDAO.pegarID(cliente);
			int id = cliente.getId();
			AvaliacaoDAO.adicionarParaAvalicao(id);
			
		}else if(action.equals("/fimCadastroBeneficiario") && cliente.getEscolha().equals("Fisica")) {
			cliente.setDescricao(request.getParameter("explicacao"));
			
			
			EnderecoDAO.create(cliente.getEndereco());
			EnderecoDAO.pegarID(cliente.getEndereco());
			CadastroDAO.createFisica(cliente);
			CadastroDAO.pegarID(cliente);
			int id = cliente.getId();
			AvaliacaoDAO.adicionarParaAvalicao(id);
			
			
		}
		doGet(request, response);
	}

}
