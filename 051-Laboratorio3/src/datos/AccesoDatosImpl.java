package datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import peliculas.*;
import excepciones.*;

/**
 * @author gm
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {//verifica que exista el archivo
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {//retorna una lista de peliculas
        File archivo = new File(nombreArchivo);//recibe un nombre de archivo y apunta al mismo
        List<Pelicula> peliculas = new ArrayList(); //una lista de tipo pelicula
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));//crea la variable de entrada, buffer lee la linea
            String linea = null;
            linea = entrada.readLine(); //lee la primera linea
            while (linea != null) {//mientras haya info sigue leyendo
                Pelicula pelicula = new Pelicula(linea);//una linea = una pelicula
                peliculas.add(pelicula);//la adiciona a la lista de pelis
                linea = entrada.readLine();//lee la siguiente
            }
            entrada.close();//cerrar el buffer de lectura
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return peliculas;//retornar la lista de pelis
    }

    
    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
    	//recibe una peli, un archivo y un bool
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));//anexar = true, agrega sin borrar
            salida.println(pelicula.toString());//imprime en el archivo la pelicula (el nombre)
            salida.close();//cierra archivo
            System.out.println("Se ha escrito correctamente al archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String buscar(String buscar, String nombreArchivo) {//recibe la peli a buscar y el archivo en cuestion
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));//vamos a leer el archivo completo
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {//mientras haya info lee
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {//si la peli a buscar es igual a alguna peli
                	//dentro del archivo, entonces entra.. ignora mayus
                    resultado = "Pelicula " + linea + " encontrada en indice " + i; 
                    //linea guarda cada linea del archivo que lee
                    //resultado guarda la frase "peli encontrada en: ", que luego retornara la funcion y corta el bucle
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();//cerrar el archivo de lectura
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public void crear(String nombreArchivo) {//crear archivo
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();//lo crea y lo cierra, no olvidar cerrar los archivos.
            System.out.println("Se ha creado el archivo correctamente");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();//abre el vinculo al archivo y luego lo borra
        System.out.println("Se ha borrado el archivo correctamente");
    }
}
