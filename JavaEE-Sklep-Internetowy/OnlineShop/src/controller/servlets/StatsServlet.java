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
import model.beans.SoldStats;


@WebServlet("/admin/stats")
public class StatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SoldStats soldStats = new SoldStats(InitDB.getSaleDAO().getAllSales());
		final List<Phone> phones = InitDB.getPhoneDAO().getAllPhone();
		

		request.setAttribute("storage", soldStats.getPhones(phones));
		request.setAttribute("sold", soldStats.soldLastMonth());	
		request.setAttribute("comboChart", soldStats.soldComboChartData(phones));

		request.getRequestDispatcher("/WEB-INF/view/stats.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
