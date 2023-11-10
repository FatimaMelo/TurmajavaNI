package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;



/**
 * Servlet implementation class ClienteController
 */
@WebServlet({"/ClienteController","/novocliente"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	Cliente cli = new Cliente();
	
	
	
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acao = request.getServletPath();
		
		if(acao.equals("/novocliente")) {
			EnviaDados(request,response);
		}
		
		
		
	}
	
	protected void EnviaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cli.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
		cli.setNome(request.getParameter("nome"));
		cli.setTelefone(request.getParameter("telefone"));
		cli.setEmail(request.getParameter("email"));
		
		
		PrintWriter pw = response.getWriter();
		pw.println("Nome do Cliente:  "+cli.getNome());
		pw.println("Telefone do Cliente:  "+cli.getTelefone());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
