package test;

import java.sql.SQLException;
import java.util.List;
import datos.PersonaJDBC;
import domain.Persona;


public class ManejoPersonas {
	public static void main(String[] args){
		PersonaJDBC personaJDBC = new PersonaJDBC();
		
		
		//PRUEBA SELECT
		List<Persona> personas = personaJDBC.select();
		//hacemos el select y mostramos los resultados en un for
		for(Persona persona: personas) {
			System.out.println("persona: "+persona);
		}
		
		
		//PRUEBA INSERT
		/*
		Persona persona1= new Persona();
		persona1.setNombre("clara");
		persona1.setApellido("pipona");
		persona1.setEmail("cpipona@mail.com");
		persona1.setTelefono("1144559988");
		*/
		//insertamos un persona.. si no comentamos la linea, se agregara una persona a cada rato
		
		//personaJDBC.insert(persona1);
		
		
		//PRUEBA UPDATE
		/*
		Persona persona2 = new Persona();
		persona2.setId_Persona(3);
		persona2.setNombre("clara");
		persona2.setApellido("warra");
		persona2.setEmail("cwarra@mail.com");
		persona2.setTelefono("46573849");
		*/
		//si solo quiero cambiar un dato, los otros debo colocarlos igualitos
		
		//personaJDBC.update(persona2);
		
		
		//PRUEBA DELETE
		/*
		Persona persona3 = new Persona();
		persona3.setId_Persona(4);
		*/
		
		//personaJDBC.delete(persona3);
	}
}
