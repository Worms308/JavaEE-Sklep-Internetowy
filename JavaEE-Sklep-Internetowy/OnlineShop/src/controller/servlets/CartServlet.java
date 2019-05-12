package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.AddToCart;
import model.cart.ShoppingCart;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		response.getWriter().println(cart.getTotalPriceWithDiscount().doubleValue());
		response.getWriter().println(cart.getPhonesWithQuantity().size());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		
		AddToCart addToCart = new AddToCart();
		addToCart.addToCart(cart, id);
		
		response.sendRedirect(request.getHeader("referer"));
	}

}
