package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description = "Lanzando Login Servlet", 
		urlPatterns = { "/LoginServlet" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "alex"), 
				@WebInitParam(name = "password", value = "1234")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get request parameters for userID and password
		String user = request.getParameter("user");
//		String pwd = request.getParameter("pwd");
		
		// Añadir cookies
		Cookie loginCookie = new Cookie("user",user);
		//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(60);
		response.addCookie(loginCookie);
		
		
		// Modificar el JSP
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		request.setAttribute("nombre",user);
		rd.include(request, response);
		//response.sendRedirect("result.jsp");
		
		
		//Busca en BBDD el usuario sus detalles (si es que existe)
		//renderiza los datos de usuario en el JSP
		//Sustituir por lineas 50 y 51 la consulta de usuario
		//....
		
//		1- Filtro de login: Mira USER + PASSWORD
//		2- Filtro de ROL --> OK
//		3- Ejecuta lo que quede en el Servlet
		
	    // "Base de datos" de usuarios
		//	    HashMap<String, String> usuarios = new HashMap<String, String>();
		//	    usuarios.put("admin", "2222");
		//	    usuarios.put("gestor", "5555");
		//	    usuarios.put("usuario", "1111");
		//	    usuarios.put("alex", "1234");
		
		//get servlet config init params
		//String userID = getServletConfig().getInitParameter("user");
		//String password = getServletConfig().getInitParameter("password");
		
		//if(user.equals(userID) && pwd.equals(password)){
	
		
		/*
		
		if(pwd.equals(usuarios.get(user))){
			// Aañadir cookies
			Cookie loginCookie = new Cookie("user",user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(60);
			response.addCookie(loginCookie);
			
			
			// Modificar el JSP
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
			request.setAttribute("nombre",user);
			rd.include(request, response);
			//response.sendRedirect("result.jsp");
			
			

		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Contraseña erronea</font>");
			rd.include(request, response);
			
		}*/
		
	}

}
