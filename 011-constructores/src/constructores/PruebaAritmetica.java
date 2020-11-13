package constructores;
public class PruebaAritmetica {

    
    public static void main(String[] args) {
        
        //Creamos un objeto de tipo aritmetica
        Aritmetica aritmetica = new Aritmetica();
        aritmetica.a = 10;
        aritmetica.b = 3;
        int resultado = aritmetica.sumar();
        
        System.out.println("resultado = " + resultado);
        
        //Creacion de un segundo objeto Aritmetica
        Aritmetica aritmetica2 = new Aritmetica(4, 2);
        System.out.println("resultado2 = " + aritmetica2.sumar() );
        
    }
}
