package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.beans.ChangePassword;

@WebServlet("/account/edit")
public class AccountEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "");
		request.getRequestDispatcher("/WEB-INF/view/account_edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actualPass = request.getParameter("actual_pass");
		String newPass = request.getParameter("new_pass");
		String newPass2 = request.getParameter("new_pass2");
		
		ChangePassword changePassword = new ChangePassword();
		String status = changePassword.change((User) request.getSession().getAttribute("user"), actualPass, newPass, newPass2);
		
		request.setAttribute("status", status);
		
		request.getRequestDispatcher("/WEB-INF/view/account_edit.jsp").forward(request, response);
	}

}
