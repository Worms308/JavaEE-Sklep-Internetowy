package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InitDB;
import model.beans.ChangeDescription;

@WebServlet("/admin/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("users", InitDB.getUserDAO().getAllUser());
		request.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ChangeDescription changeDescription = new ChangeDescription();
		changeDescription.changeDescription(Integer.parseInt(id));
		
		doGet(request, response);
	}

}
