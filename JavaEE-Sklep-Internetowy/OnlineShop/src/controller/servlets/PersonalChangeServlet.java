package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.beans.ChangePersonalData;


@WebServlet("/account/edit/personal_change")
public class PersonalChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setPhone(phone);
		user.setEmail(email);
		
		ChangePersonalData changePersonalData = new ChangePersonalData();
		changePersonalData.change((User) request.getSession().getAttribute("user"), user);
		
		response.sendRedirect(request.getHeader("referer"));
	}

}
