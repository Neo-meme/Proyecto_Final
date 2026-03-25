import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutable{

    //seccion de variables globales, para que estas puedan ser utilizadas en cualquier parte del programa, como por ejemplo en el menu o en la seccion de ingreso de datos.
    static Scanner sc= new Scanner(System.in);
    static String nombre; // Variable para almacenar el nombre del cliente
    static double distancia;
    static double carga;
    static int opcion;

    // seccion donde ingresa los datos el usuario(peso y distancia) y llama al metodo menu para iniciar todo.
    public static void Run(){

        System.out.println("\n=== Bienvenido al Sistema de Transporte ===");
        System.out.println("===========================================");
          // Validación del nombre con try-catch
        boolean nombreValido = false;
        while (!nombreValido) {
            try {
                System.out.println("\nPor favor, ingresa tu nombre:");
                nombre = sc.nextLine();
                
                // .trim() elimina espacios en blanco al inicio y al final
                if (nombre.trim().isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío ni contener solo espacios.");
                }
                nombreValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("¡Error! " + e.getMessage());
            }
        }

        
        // Validación de distancia y carga para evitar negativos y letras
        boolean datosIngresados = false;
        while (!datosIngresados) {
            try {
                System.out.println("\nHola " + nombre + ", ingresa la distancia (en km):");
                distancia = Double.parseDouble(sc.nextLine()); // Usamos parseDouble para evitar el bug del Scanner

                if (distancia <= 0) {
                    throw new IllegalArgumentException("La distancia no puede ser un número negativo.");
                }

                System.out.println("Ingresa la carga a transportar (en kg):");
                carga = Double.parseDouble(sc.nextLine());

                if (carga <= 0) {
                    throw new IllegalArgumentException("La carga no puede ser un número negativo.");
                }
                
                datosIngresados = true; 
            } catch (NumberFormatException e) { 
                // Atrapa el error si el usuario escribe letras en lugar de números
                System.out.println("¡Error! Por favor, ingresa únicamente valores numéricos válidos.");
            } catch (IllegalArgumentException e) {
                // Atrapa el error si son números negativos
                System.out.println("¡Error! " + e.getMessage());
            }
        }

        System.out.println("\n===========================================");
        /*
            crearcion de objetos para cada tipo de vehiculo 
            EJEMPLO Tengo un vehículo, pero en realidad es un camión, un automóvil, un dron, etc. Esto es polimorfismo. !acordarse!

            se crea un arreglo de tipo Vehiculo, dentro del arreglo se crean los objetos de las clases concretas (Automovil, Dron, etc )
            ya que crear un objeto de la clase Vehiculo no es posible.

         */
        
        Vehiculo[] vehiculos = { 
            new Moto(),
            new Automovil(),
            new Camion(),
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
            System.out.println("Lo sentimos, no hay vehículos disponibles para esa carga y distancia.");
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
        System.out.println("\n=== COMPARATIVA Y OPCIONES DE VEHÍCULOS DISPONIBLES ===");

        for (int i = 0; i < disponibles.size(); i++) { {
            Vehiculo v = disponibles.get(i);
            System.out.println((i + 1) + ". " + v +
                "\n | Costo: $" + v.calcularCosto(distancia, carga) +" COP "+
                " | Tiempo estimado: " + v.calcularTiempo(distancia) +
                " | Huella ecologica: " + v.calcularHuella(distancia, carga));
            }
        }

        // Elegir con validación y try-catch genérico
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("\nSeleccione una opción:");
                opcion = sc.nextInt();

                if (opcion >= 1 && opcion <= disponibles.size()) {
                    Vehiculo elegido = disponibles.get(opcion - 1);
                    
                    // Mensaje emocionante usando el nombre ingresado
                    System.out.println("\n=======================================================");
                    System.out.println("¡Excelente elección, " + nombre );
                    System.out.println("Has reservado con éxito: " + elegido.getClass().getSimpleName());
                    System.out.println("¡Nos emociona muchísimo acompañarte en esta ruta! Gracias");
                    System.out.println("por confiar en nuestro sistema para mover tu carga.");
                    System.out.println("¡Prepárate, porque tu envío está en las mejores manos!");
                    System.out.println("=======================================================\n");
                    
                    opcionValida = true; 
                }else {
                    System.out.println("Opción inválida. Por favor, selecciona un número entre 1 y " + disponibles.size() + ".");
                }
            } catch (Exception e) { // Usamos Exception genérica aquí también
                System.out.println("¡Error! Debes ingresar un número entero correspondiente a tu elección.");
                sc.nextLine(); 
            }
        }    
    }
}

