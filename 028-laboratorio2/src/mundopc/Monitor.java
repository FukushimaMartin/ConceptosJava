package mundopc;

//Creación de la clase
public class Monitor {
    //Declaración de variables
    private final int idMonitor;
    private String marca;
    private double tamanio;
    private static int contadorMonitores;

    private Monitor(){
         idMonitor = ++contadorMonitores;
   }
    
    //Constructor que inicializa las variables
    public Monitor(String marca, double tamanio) {
        this();
        this.marca = marca;
        this.tamanio = tamanio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
      public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    //Método que concatena las variables y regresa una cadena
    @Override
    public String toString() {
        return "Monitor{" + " idMonitor=" + idMonitor + ", marca=" + marca + ", tama�o=" + tamanio + '}';
    }

}
