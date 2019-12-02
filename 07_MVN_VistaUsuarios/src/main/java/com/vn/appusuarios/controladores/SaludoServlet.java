package com.vn.appusuarios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Descriptores de servlets
@WebServlet({"/saludo", "/otraurl"  })
public class SaludoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		
		String nombre = req.getParameter("nombre");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>" + nombre);
		Cookie[] todasCookies = req.getCookies();
		Cookie nombreCookie = null;
		boolean hayCookie = false;
		for (Cookie co : todasCookies) {
			if (co.getName().equals("nombre_cookie")) {
				hayCookie = true;
				nombreCookie = co;
			}
		}
		if ( ! hayCookie) {
			nombreCookie = new Cookie("nombre_cookie", "Valor de la cokie: " + nombre);	
			// nombreCookie.setMaxAge(0);
		} 
		resp.addCookie(nombreCookie);
		
		System.out.println("Cookie desde navegador: " + todasCookies[0].getValue());
		if (nombreCookie != null) {
			System.out.println("Cookie desde navegador: " + nombreCookie.getValue());
		}
		
		resp.getWriter().println("<div id='divC'></div>");
		resp.getWriter().println("<script>");
		resp.getWriter().println("document.getElementById('divC').innerHTML = document.cookie; ");
		//resp.getWriter().println("document.cookie='nombre_cookie=\"Modificada en JS: \" '; ");
		
		resp.getWriter().println("</script></body></html>");
	}
}






