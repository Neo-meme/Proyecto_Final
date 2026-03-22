import java.util.Scanner;

public class Ejecutable{

    //seccion de variables globales, para que estas puedan ser utilizadas en cualquier parte del programa, como por ejemplo en el menu o en la seccion de ingreso de datos.
    static Scanner sc= new Scanner(System.in);
    static double distancia;
    static double carga;
    static int opcion;

    // seccion donde ingresa los datos el usuario(peso y distancia) y llama al metodo menu para iniciar todo.
    public static void Run(){
    
        System.out.println("Ingrese la distancia (en km):");
        distancia = sc.nextDouble();

        System.out.println("Ingrese la carga a transportar (en kg):");
        carga = sc.nextDouble();
        /*
            crearcion de objetos para cada tipo de vehiculo 
            EJEMPLO Tengo un vehículo, pero en realidad es un camión, un automóvil, un dron, etc. Esto es polimorfismo. !acordarse!
            
            se crea un arreglo de tipo Vehiculo, dentro del arreglo se crean los objetos de las clases concretas (Automovil, Dron, etc )
            ya que crear un objeto de tipo Vehiculo no es posible.

         */
        
        Vehiculo[] vehiculos = {
            //new Moto(),
            new Automovil(),
            //new Camion(),
            new Dron()
        };
    }

 

    

    
  
    
}

