package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cadastro;

/**
 * Servlet implementation class CreateCadastro
 */
@WebServlet({ "/criandoCadastro", "/pessoaFisica", "/pessoaJuridica" })
public class CreateCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cadastro cliente = new Cadastro();
       
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
		}
		doGet(request, response);
	}

}
