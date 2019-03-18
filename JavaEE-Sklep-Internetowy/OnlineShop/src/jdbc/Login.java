package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Database.getDbUrl(),Database.getUsernameDB(),Database.getPasswordDB());

			String login=request.getParameter("login");
			String password=request.getParameter("password");
			String query="select login,password from user where login=? and password=?";
			String dbLogin=null;
			String dbPassword=null;
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,login);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				dbLogin=rs.getString(1);
				dbPassword=rs.getString(2);
			}
			if(login.equals(dbLogin)&&password.equals(dbPassword))
			{
				System.out.println("Zostales poprawnie zalogowany");
				conn.close();
				HttpSession session = request.getSession();
				session.setAttribute("user",login);
				session.setMaxInactiveInterval(30*60);
				Cookie userName=new Cookie("user",login);
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				response.sendRedirect("after_auth.jsp");
			}
			else
			{
				conn.close();
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				PrintWriter out= response.getWriter();
				System.out.println("Bledny login lub haslo");
				out.println("<font color=black><center><strong>Either user name or password is wrong.</strong></center></font>");
				rd.include(request, response);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException ce) {
			
		}
	}
}