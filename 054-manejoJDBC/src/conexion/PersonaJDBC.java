package conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Persona;

public class PersonaJDBC {	
	private static final String SQL_SELECT = "select * from persona";
	private static final String SQL_INSERT = "insert INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "update persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
	private static final String SQL_DELETE = "delete FROM persona WHERE id_persona=?";
	//como no sabemos aun que datos se usaran, ponemos "=?", significa que luego se completara
	
	public List<Persona> select() {
		//creo las variables que utilizare
		Connection conexion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			conexion = Conexion.getConnection();
			stmt = conexion.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			//seteo la conexion y demases
			
			while(rs.next()) {
				int id_persona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				//esto es una paja, pero por cada linea que leo, guardo en variables locales
				//la columna la puedo pasar con numero o bien el nombre de la misma
				
				persona = new Persona();
				//creo mi persona y le seteo los valores obtenidos
				
				persona.setId_Persona(id_persona);
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				persona.setEmail(email);
				persona.setTelefono(telefono);
				
				//agregamos cada persona a la lista de personas
				personas.add(persona);
			}
			
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}finally {//cerrar las conexiones o morir explotado
			Conexion.close(conexion);
			Conexion.close(stmt);
			Conexion.close(rs);
		}
		
		return personas;
		//retorno la lista de personas obtenidas
	}
	
	
	//Metodo Insert
	public int insert(Persona persona) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		
		int filas = 0;
		
		try {
			conexion = Conexion.getConnection();
			System.out.println("ejecutando Query: "+ SQL_INSERT);
			stmt = conexion.prepareStatement(SQL_INSERT);
			
			//el stmt es la query, como colocamos signo de pregunta '?' en cada campo, debemos indicar a cual nos referimos
			//en el caso del insert hay 4, 'VALUES(?,?,?,?)' entonces colocamos (1, persona.get...)(2, persona.get...)
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			
			filas = stmt.executeUpdate();
			//en el update puedo pasar un parametro con la query, pero en este caso el stmt ya contiene la query entonces no hace falta
			System.out.println("registros afectados: "+filas);
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(conexion);
			Conexion.close(stmt);
		}
		return filas;
	}
	
	
	
	//Metodo Update
	public int update(Persona persona) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		
		int filas = 0;
		
		try {
			conexion = Conexion.getConnection();
			System.out.println("ejecutando query: "+ SQL_UPDATE);
			stmt = conexion.prepareStatement(SQL_UPDATE);
			
			//seteo un string, en la posicion x, con la info en persona
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getId_Persona());
			//el update precisa que le pases todas las columnas
			
			filas = stmt.executeUpdate();
			System.out.println("registros afectados: "+filas);
			
		}catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(conexion);
			Conexion.close(stmt);
		}
		return filas;
	}
	
	
	//Metodo Delete
	public int delete(Persona persona) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		
		int filas = 0;
		
		try {
			conexion = Conexion.getConnection();
			System.out.println("ejecutando query: "+ SQL_DELETE);
			stmt = conexion.prepareStatement(SQL_DELETE);
			
			//le indico el index que deseo eliminar, lo tomo del id persona
			//el stmt es la query, como colocamos signo de pregunta '?' en cada campo, debemos indicar a cual nos referimos
			//en el caso del delete solo hay 1, el id_persona=?.. entonces colocamos (1, persona.get...)
			stmt.setInt(1, persona.getId_Persona());
			
			filas = stmt.executeUpdate();
			System.out.println("registros eliminados: "+filas);
			
			
		}catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(conexion);
			Conexion.close(stmt);
		}
		return filas;
		
	}
	
}
