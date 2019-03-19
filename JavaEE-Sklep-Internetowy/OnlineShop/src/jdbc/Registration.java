package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method s
		try {
			final String usernameDB="root";
			final String passwordDB="root";
			final String dbUrl ="jdbc:mysql://localhost/phone_store?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String name=request.getParameter("name");
			String surname=request.getParameter("surname");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			String repassword=request.getParameter("repassword");
			String country=request.getParameter("country");
			String city=request.getParameter("city");
			String street=request.getParameter("street");
			String street_number=request.getParameter("street_number");
			String home_number=request.getParameter("home_number");
			String postal_code=request.getParameter("postal_code");
			
			//String user=request.getParameter("username");
			//session.putValue("username",user);
			//String email=request.getParameter("email");
			//String password=request.getParameter("password");
			//String repassword=request.getParameter("repassword");
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection(dbUrl,usernameDB,passwordDB);
				//dodanie adresu
				String query = "insert into address(country,city,street,street_number,home_number,postal_code) values(?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setString(1,country);
				ps.setString(2,city);
				ps.setString(3, street);
				ps.setString(4, street_number);
				ps.setString(5, home_number);
				ps.setString(6, postal_code);
				ps.execute();
				ps.close();
				
				//dodanie usera
				query="select last_insert_id()";
				ps=conn.prepareStatement(query);
				
				Integer user_address_id=null;
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					user_address_id=rs.getInt(1);
				}
				query = "insert into user(name,surname,email,phone,login,password,user_usertype_id,user_address_id) values(?,?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(query);
				ps.setString(1,name);
				ps.setString(2,surname);
				ps.setString(3,email);
				ps.setString(4,phone);
				ps.setString(5, login);
				ps.setString(6, password);
				ps.setInt(7, 2);
				ps.setInt(8, user_address_id);
				
				if(password.equals(repassword))
				{
				ps.execute();
				ps.close();
				conn.close();
				HttpSession ses = request.getSession(true);
				PrintWriter out = response.getWriter();
				System.out.println("Zarejestrowany!");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request,response);
				}
				else
				{
					PrintWriter out= response.getWriter();
					out.println("<font color=black>Has�a nie s� zgodne.</font>");
					conn.close();
				}
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
