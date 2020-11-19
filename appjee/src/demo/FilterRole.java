package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet Filter implementation class FilterRole
 */
@WebFilter("/FilterRole")
public class FilterRole implements Filter {

    /**
     * Default constructor. 
     */
    public FilterRole() {
        // TODO Auto-generated constructor stub
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
        
	    String user = request.getParameter("user");  
	    if(usuarios.containsKey(user)){  
	    	
	    	switch(user){
		    	case "admin":
					out.println("<font color=red>Bienvenido ADMIN</font>");
					break;
		    	case "gestor":
		    		out.println("<font color=red>Bienvenido señor gestor</font>");
		    		break;
		    	case "usuario":
		    		out.println("<font color=red>Bienvenido usuario normal</font>");
		    		break;
		    	case "alex":
		    		out.println("<font color=red>Bienvenido superadmin</font>");
	    	}
	    	
	    chain.doFilter(request, response);//sends request to next resource 
	    System.out.println("Usuario con permisos entrando!!!!");
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
		System.out.println("LAnzando el filtro de roles!!!!!!");
	}

}
