package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.RegisterBean;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String surname = (String) request.getParameter("surname");
		String phone = (String) request.getParameter("phone");
		String country = (String) request.getParameter("country");
		String city = (String) request.getParameter("city");
		String street = (String) request.getParameter("street");
		String streetNum = (String) request.getParameter("streetNum");
		String home = (String) request.getParameter("home");
		String postal = (String) request.getParameter("postal");
		String login = (String) request.getParameter("username");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String password2 = (String) request.getParameter("password2");
		
		RegisterBean registerBean = new RegisterBean();
		if (registerBean.registerUser(name, surname, phone, country, city, street, streetNum, home, postal, login, email, password, password2)) {
			System.out.println("dodano");
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}
	}

}
