package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InitDB;
import entities.Phone;
import model.beans.FilterData;
import model.filter.PhoneFilter;


@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Phone> phones = InitDB.getPhoneDAO().getAllPhone();
		FilterData data = new FilterData(phones);
		
		request.setAttribute("phones", phones);
		request.setAttribute("manufacturers", data.getAvaiableManufacturers());
		request.setAttribute("models", data.getAvaiableModels());
		request.setAttribute("system", data.getAvaiableSystems());
		request.setAttribute("processor", data.getAvaiableProcessor());
		
		request.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Phone> phones = InitDB.getPhoneDAO().getAllPhone();
		
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String processor = request.getParameter("processor");
		String system = request.getParameter("system");
		String screen = request.getParameter("screen");
		String ram = request.getParameter("ram");
		String storage = request.getParameter("storage");
		String camera = request.getParameter("camera");
		String price = request.getParameter("price");
		String rating = request.getParameter("rating");
		
		System.out.println(price);
		
		FilterData data = new FilterData(phones);
		
		PhoneFilter filter = new PhoneFilter(phones);
		filter.filterByAll(manufacturer, model, processor, system, screen, ram, storage, camera, price, rating);
		phones = filter.getPhones();
		
		request.setAttribute("phones", phones);
		request.setAttribute("manufacturers", data.getAvaiableManufacturers());
		request.setAttribute("models", data.getAvaiableModels());
		request.setAttribute("system", data.getAvaiableSystems());
		request.setAttribute("processor", data.getAvaiableProcessor());
		
		request.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(request, response);
	}

}
