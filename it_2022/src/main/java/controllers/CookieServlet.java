package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		HttpSession session = request.getSession(false);
		User loggedUser = (session!=null)?(User)session.getAttribute("loggedUser"):null;
		
		if(loggedUser!=null) {
		Cookie pesho = new Cookie("myCookie","myCookie");
		pesho.setMaxAge(15);
		response.addCookie(pesho);
		
		response.sendRedirect("user?id="+loggedUser.getId());
		} 
		else {
			response.sendRedirect("login");
		}
	}
}
