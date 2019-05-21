package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.beans.RealizeOrder;
import model.cart.ShoppingCart;

/**
 * Servlet implementation class RealizeServlet
 */
@WebServlet("/realize")
public class RealizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delivery = request.getParameter("delivery");
		String payment = request.getParameter("payment");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		
		RealizeOrder realizeOrder = new RealizeOrder();
		realizeOrder.realize(user, cart, delivery, payment);
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}
