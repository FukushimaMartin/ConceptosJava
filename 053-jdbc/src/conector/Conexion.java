package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	//"jdbc:sqlserver://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimeZone=true&serverTimeZone=UTC"
	public static void main(String[] args) throws SQLException {
		Connection conexion = null;
		String sDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String password = "admin";
		//muy importante, la puta conexion no se daba, me faltaba algo de la zona horaria, porque soy un argentino petón
		try {
			Class.forName(sDriver);
			conexion = DriverManager.getConnection(url,usuario,password);
			
			//creamos el statement
			Statement instruccion = conexion.createStatement();
			
			//creamos la query
			String sql = "select id_persona, nombre, apellido, email, telefono from persona";
			
			//ejecutamos la query
			ResultSet resultado = instruccion.executeQuery(sql);
			
			//procesamoe el resultado
			while(resultado.next()) {//va abanzando por cada resultado
				System.out.println("Id persona: "+resultado.getInt(1)); //le paso la columna q precisamos
				System.out.print(" Nombre: "+resultado.getString(2));
				System.out.print(" Apellido: "+resultado.getString(3));
				System.out.print(" Email: "+resultado.getString(4));
				System.out.println(" Telefono: "+resultado.getString(5)+"\n");
			}
			//cerramos los objetos creados
			resultado.close();
			instruccion.close();
			conexion.close();
			
			//Statement se utiliza para cualquier tipo de sentencia SQL, pero
			//          no hace cache del SQL ejecutado
			
			//PreparedStatement  se usa para hacer cache del query a ejecutar, 
			//                   evitando la recompilacion de la sentencia SQL
			//       este es bueno para no consumir tantos recursos de la base
			
			//CallableStatement  se utiliza para llamar a procedimientos almacenados
			//                   en una base de datos
			//     con este armo procedimientos y los ejecuto desde el codigo
			
			
			//Metodos de la interface Statement
			/*
			 * ResultSet executeQuery (String sql) - recibe un select string(query), devuelve un ResultSet 
			 * Int executeUpdate (String sql) - para Insert, Update, Delete - devuelve la cantidad de filas afectadas
			 * Boolean execute(String) - True si fue un ResultSet (select) o False si fue otro tipo de consulta
			 * */
			
		}catch (Exception e) {
			e.printStackTrace(System.out);
			conexion = null;
		} finally {
			try {
				if(conexion != null) {
					System.out.println("Conectado");
					System.out.println(conexion);
					conexion.close();
				}else {
					System.out.println("Desconectado");
				}
			}catch(SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
	}
}
