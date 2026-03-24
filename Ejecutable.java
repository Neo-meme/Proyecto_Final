import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutable {

    // seccion de variables globales
    static Scanner sc = new Scanner(System.in);
    static String nombre; // Nueva variable para almacenar el nombre del cliente
    static double distancia;
    static double carga;
    static int opcion;

    // seccion donde ingresa los datos el usuario y llama al metodo menu para iniciar todo.
    public static void Run() {

        System.out.println("\n=== Bienvenido al Sistema de Transporte ===");
        System.out.println("===========================================");
        
        // Pedimos el nombre antes de entrar a pedir los números
        System.out.println("\nPor favor, ingresa tu nombre:");
        nombre = sc.nextLine();

        // Bucle con try-catch para validar distancia y carga
        boolean datosIngresados = false;
        while (!datosIngresados) {
            try {
                // Usamos el nombre para que el sistema sea más amigable
                System.out.println("\nHola " + nombre + ", ingresa la distancia (en km):");
                distancia = sc.nextDouble();

                System.out.println("Ingresa la carga a transportar (en kg):");
                carga = sc.nextDouble();
                
                datosIngresados = true; 
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Por favor, ingresa únicamente valores numéricos (si usas decimales, revisa si tu sistema usa punto o coma).");
                sc.nextLine(); // Limpia el buffer
            }
        }

        System.out.println("\n===========================================");
        
        Vehiculo[] vehiculos = { 
            new Moto(),
            new Automovil(),
            new Camion(),
            new Dron()
        };

        ArrayList<Vehiculo> disponibles = new ArrayList<>();

        // Filtrar vehículos
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.validarCarga(carga) && vehiculo.validarDistancia(distancia)){
                disponibles.add(vehiculo);
            }    
        }

        // Validar si hay opciones
        if (disponibles.isEmpty()) {
            System.out.println("Lo sentimos, no hay vehículos disponibles para esa carga y distancia.");
            return; 
        }

        // Método burbuja para ordenar
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

        for (int i = 0; i < disponibles.size(); i++) { 
            Vehiculo v = disponibles.get(i);
            System.out.println((i + 1) + ". " + v.getClass().getSimpleName() +
                "\n | Costo: $" + v.calcularCosto(distancia, carga) +" COP "+
                " | Tiempo estimado: " + v.calcularTiempo(distancia) +
                " | Huella ecologica: " + v.calcularHuella(distancia, carga));
        }

        // Elegir con validación y try-catch
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("\nSeleccione una opción:");
                opcion = sc.nextInt();

                if (opcion >= 1 && opcion <= disponibles.size()) {
                    Vehiculo elegido = disponibles.get(opcion - 1);
                    
                    // Mensaje emocionante usando el nombre ingresado
                    System.out.println("\n=======================================================");
                    System.out.println("¡Excelente elección, " + nombre + "! 🚀🎉");
                    System.out.println("Has reservado con éxito: " + elegido.getClass().getSimpleName());
                    System.out.println("¡Nos emociona muchísimo acompañarte en esta ruta! Gracias");
                    System.out.println("por confiar en nuestro sistema para mover tu carga.");
                    System.out.println("¡Prepárate, porque tu envío está en las mejores manos!");
                    System.out.println("=======================================================\n");
                    
                    opcionValida = true; 
                } else {
                    System.out.println("Opción inválida. Por favor, selecciona un número entre 1 y " + disponibles.size() + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Debes ingresar un número entero correspondiente a tu elección.");
                sc.nextLine(); 
            }
        }
    }
}
    
    }
}
