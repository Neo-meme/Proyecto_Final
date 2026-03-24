import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutable {

    // seccion de variables globales
    static Scanner sc = new Scanner(System.in);
    static String nombre; // Variable para almacenar el nombre del cliente
    static double distancia;
    static double carga;
    static int opcion;

    // seccion donde ingresa los datos el usuario y llama al metodo menu para iniciar todo.
    public static void Run() {

        System.out.println("\n=== Bienvenido al Sistema de Transporte ===");
        System.out.println("===========================================");
        
        System.out.println("\nPor favor, ingresa tu nombre:");
        nombre = sc.nextLine();

        // Bucle con try-catch genérico (Exception) para validar distancia y carga
        boolean datosIngresados = false;
        while (!datosIngresados) {
            try {
                System.out.println("\nHola " + nombre + ", ingresa la distancia (en km):");
                distancia = sc.nextDouble();

                System.out.println("Ingresa la carga a transportar (en kg):");
                carga = sc.nextDouble();
                
                datosIngresados = true; 
            } catch (Exception e) { // Usamos Exception genérica aquí
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
            System.out.println((i + 1) + ". " + v +
                "\n | Costo: $" + v.calcularCosto(distancia, carga) +" COP "+
                " | Tiempo estimado: " + v.calcularTiempo(distancia) +
                " | Huella ecologica: " + v.calcularHuella(distancia, carga));
        }

        // Elegir con validación y try-catch genérico
        boolean opcionValida = false;
