package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Address;
import entities.User;
import model.beans.ChangeAddress;


@WebServlet("/account/edit/address_change")
public class AddressChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String streetNumber = request.getParameter("street_number");
		String houseNumber = request.getParameter("house_number");
		String postalCode = request.getParameter("postal_code");
		
		Address address = ((User)request.getSession().getAttribute("user")).getAddress();
		address.setCountry(country);
		address.setCity(city);
		address.setStreet(street);
		address.setStreetNumber(streetNumber);
		address.setHomeNumber(houseNumber);
		address.setPostalCode(postalCode);
		
		ChangeAddress changeAddress = new ChangeAddress();
		changeAddress.change((User) request.getSession().getAttribute("user"), address);
		
		response.sendRedirect(request.getHeader("referer"));
	}

}
