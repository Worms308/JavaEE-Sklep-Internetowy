package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cart.RemoveFromCart;
import model.cart.ShoppingCart;


@WebServlet("/cart/remove")
public class CartRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));

		//RemoveFromCart removeFromCart = new RemoveFromCart();
		RemoveFromCart.removeFromCart(cart, id);
		
		response.sendRedirect(request.getHeader("referer"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getHeader("referer"));
	}

}
