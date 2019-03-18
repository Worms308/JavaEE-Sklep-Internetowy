import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class TestMySQLConnection {
static String username="root";
static String password="root";
//static String dbUrl="jdbc:mysql://localhost:3306/phone_store";
static String dbUrl ="jdbc:mysql://localhost/phone_store?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, username, password);
			
			System.err.println("Connection estabilished to mysql database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		finally
		{
			conn.close();
		}

	}

}
