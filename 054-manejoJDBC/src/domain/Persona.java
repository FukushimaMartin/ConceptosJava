package domain;

public class Persona {
	private int id_persona;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	public int getId_Persona() {
		return id_persona;
	}
	public void setId_Persona(int id) {
		this.id_persona = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String a) {
		this.apellido = a;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String e) {
		this.email = e;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String t) {
		this.telefono = t;
	}
	
	@Override
	public String toString() {
		return "Persona(id_persona: " +id_persona+ ", nombre: " +nombre+ ", apellido: " +apellido+ ", email: " +email+ ", telefono: " +telefono+ ")";
	}
}
