package jdbc;

public class Database {
	private static final String usernameDB="root";
	private static final String passwordDB="";
	private static final String dbUrl ="jdbc:mysql://localhost/phone_store?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static String getUsernameDB() {
		return usernameDB;
	}
	public static String getPasswordDB() {
		return passwordDB;
	}
	public static String getDbUrl() {
		return dbUrl;
	}
}
