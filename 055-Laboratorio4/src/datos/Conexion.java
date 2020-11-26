package datos;

import java.sql.*;

public class Conexion {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "admin";
	
	
	public static Connection getConnection() throws SQLException{
		String sDriver = "com.mysql.cj.jdbc.Driver";
		Connection cn = null;
		
		try {
			Class.forName(sDriver);
		//yo soy peton y debo colocar el class.forname.. esto me obliga a encerrarlo en un try and catch
			//el tipo excepcion es el Exception
		cn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		return cn;
	}
	
	//armo 3 metodos para cerrar los objetos de sql
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch(SQLException e){
			e.printStackTrace(System.out);
		}
	}
	
	public static void close(PreparedStatement stmt) {
		try {
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
}
