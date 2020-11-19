package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter("/FilterLogin")
public class FilterLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterLogin() {
	    
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out=response.getWriter(); 
		
		// "Base de datos" de usuarios
	    HashMap<String, String> usuarios = new HashMap<String, String>();
	    usuarios.put("admin", "2222");
	    usuarios.put("gestor", "5555");
	    usuarios.put("usuario", "1111");
	    usuarios.put("alex", "1234");
	    
		//get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
	    
	    if(pwd.equals(usuarios.get(user))){
			chain.doFilter(request, response);
	    }	    
	    else{  
		    out.print("<p>username or password error!</p>");  
		    RequestDispatcher rd=request.getRequestDispatcher("login.html");  
		    rd.include(request, response);  
	    } 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
