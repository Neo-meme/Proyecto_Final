import java.util.Scanner;

public class Ejecutable{

    static Scanner sc= new Scanner(System.in);

    static void menu(){
    
        //----Seccion de variables locales del todo el documento-----
        int opcion;
        do{
             System.out.println("----BIENVENIDO AL SISTEMA DE TRANSPORTE----");
             System.out.println("Seleccione el tipo de transporte:");
             System.out.println("1. Terrestre");
             System.out.println("2. Aéreo");
             System.out.println("0. Salir");
             System.out.println("Ingrese su opción:");
             opcion=sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--Ha seleccionado transporte terrestre.--");
                        /*
                          aca estamos creando un objeto de tipo Terrestres, casi como si fuera "Terrestres terrestre = new Terrestres()""
                          solo que esta vez despues del igual se le asigna el valor que va a devolver el método crearTerrestre() 
                        */
                        Terrestres terrestre = crearTerrestre();
                    break;
                case 2:
                    System.out.println("--Ha seleccionado transporte aéreo.--");
                    // Aquí puedes agregar la lógica para el transporte aéreo
                    break;
                case 0:
                    System.out.println("--Saliendo del sistema. ¡Hasta luego!!--");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);

    }

    /**
     * @return
     */
    static Terrestres crearTerrestre(){

        System.out.println("Seleccione tipo de vehículo terrestre:");
        System.out.println("1. Automóvil");
        System.out.println("2. Moto");
        System.out.println("3. Camión");

        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la velocidad:");
        double velocidad = sc.nextDouble();

        System.out.println("Ingrese la capacidad de carga:");
        double capacidadCarga = sc.nextDouble();

        switch(tipo){
            case 1:
                return new Automovil( velocidad, capacidadCarga);
            case 2:
                return new Moto(velocidad, capacidadCarga);
            case 3:
                return new Camion( velocidad, capacidadCarga);
            default:
                System.out.println("Opción inválida");
                return null;
        }
}
}