package controller.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InitDB;
import dao.PhoneDAO;
import entities.Phone;


@WebServlet("/admin/add_product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "");
		
		request.getRequestDispatcher("/WEB-INF/view/add_product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String processor = request.getParameter("processor");
		String system = request.getParameter("system");
		String screen = request.getParameter("screen_size");
		String ram = request.getParameter("ram");
		String storage = request.getParameter("storage");
		String camera = request.getParameter("camera");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String img = request.getParameter("img");
		
		Phone newPhone = new Phone();
		newPhone.setManufacturer(manufacturer);
		newPhone.setModel(model);
		newPhone.setProcessor(processor);
		newPhone.setSystem(system);
		newPhone.setScreenSize(screen);
		newPhone.setRam(ram);
		newPhone.setStorage(storage);
		newPhone.setCamera(camera);
		newPhone.setPrice(new BigDecimal(price));
		newPhone.setQuantity(Integer.parseInt(quantity));
		newPhone.setImg(img);
		
		newPhone.setDiscount(new BigDecimal(0.0));
		newPhone.setRating(new BigDecimal(5.0));
		newPhone.setRatingCount(1);
		
		PhoneDAO phoneDAO = InitDB.getPhoneDAO();
		
		if (phoneDAO.addPhone(newPhone))
			request.setAttribute("status", "Pomyślnie dodano");
		else
			request.setAttribute("status", "Błąd dodawania telefonu");
		request.getRequestDispatcher("/WEB-INF/view/add_product.jsp").forward(request, response);
	}

}
