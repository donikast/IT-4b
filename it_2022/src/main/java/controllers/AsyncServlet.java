package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.JsonResult;
import models.User;
import repositories.Repository;

@WebServlet("/asyncServlet")
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Repository collection;
	Gson gson;
       
  
	public void init(ServletConfig config) throws ServletException {
		collection = Repository.getInstance();
		gson = new Gson();
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Прочита текстовото съдържанието на заявката
		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = request.getReader().readLine()) != null) {
		    sb.append(s);
		}

		User newUser = (User) gson.fromJson(sb.toString(), User.class);
		User user = collection.getUserById(newUser.getId());
		
		user.setPersonalName(newUser.getPersonalName());
		
		JsonResult result = new JsonResult();
		if(user!=null) {
			result.setMessage("OK");
		}
		
		//Връщане на резултата като json
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(result)); //result обекта който щесе върне като резултат
		out.flush();
		
		
	}

}
