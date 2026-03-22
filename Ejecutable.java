import java.util.ArrayList;
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

        // aca se crea una lista llamada disponibles , donde se van a almacenar los vehiculos que cumplan con las validaciones de carga y distancia, es decir, 
        // los vehiculos que puedan transportar la carga y recorrer la distancia ingresada por el usuario.
        ArrayList<Vehiculo> disponibles = new ArrayList<>();

        // aca se filtra el arreglo , para verificar si cumplen la carga y distancia y si cumplen se agregan a la lista creada llamada disponible 
        for (Vehiculo vehiculo : vehiculos){
            if(vehiculo.validarCarga(carga) && vehiculo.validarDistancia(distancia)){
                disponibles.add(vehiculo);
            }
        }

        // Validar si hay opciones dentro de la lusta que se creo
        if (disponibles.isEmpty()) {
            System.out.println("Lo sentinmos, no hay vehículos disponibles.");
            return; // el returns sirve similar al break , termina aca y vuelve al inicio de la funcion Run()
        }

        //aca usamos el metodo burbuja para ordenar la lista disponible por costo, de menor a mayor.

        for (int i = 0; i < disponibles.size() - 1; i++) {
            for (int j = i + 1; j < disponibles.size(); j++) {

                Vehiculo actual = disponibles.get(i);
                Vehiculo siguiente = disponibles.get(j);

                if (actual.calcularCosto(distancia, carga) > 
                     siguiente.calcularCosto(distancia, carga)) {

                    disponibles.set(i, siguiente);
                    disponibles.set(j, actual);
                }
            }
        }

        // Mostrar opciones
        System.out.println("\n=== OPCIONES ===");

        for (int i = 0; i < disponibles.size(); i++) {
            Vehiculo v = disponibles.get(i);
            System.out.println((i + 1) + ". " + v +
                " | Costo: $" + v.calcularCosto(distancia, carga) +
                " | Tiempo: " + v.calcularTiempo(distancia) +
                " | Huella: " + v.calcularHuella(distancia, carga));
        }

        // Elegir
        System.out.println("\nSeleccione una opción:");
        int opcion = sc.nextInt();

        if (opcion >= 1 && opcion <= disponibles.size()) {
            Vehiculo elegido = disponibles.get(opcion - 1);
            System.out.println("Elegiste: " + elegido);
        } else {
            System.out.println("Opción inválida");
        }

        
    }

    
}

