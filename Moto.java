import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

// Para el costo de la moto, utilizamos la formula costo = (Distancia * 300) + (Peso * 30)
// Y creamos la clase (objeto) para calcular el costo del viaje del vehiculo. 
class Costo_Moto {
    
    public double CalcularCosto(double Distancia, double Carga) {
        double Costo = (Distancia * 300) + (Carga * 30);
        return Costo;
    }  
} 
class Tiempo_Viaje {
    public double CalcularTiempo(double Distancia) {
        double Tiempo = Distancia / 90.0; // La velocidad de la moto es de 90 km/h
        return Tiempo;
    }
}

public class Moto {
    // La velocidad esta evaluada en Kilometros por hora.
    private static final double VELOCIDAD = 90.0; 
    
    // La capacidad esta evaluada en Kilogramos .
    private static final double CAPACIDAD_MAXIMA = 1000.0;
    
    // La distancia esta evaluada en Kilometros .
    private static final double DISTANCIA_MAXIMA = 200.0; 

    public static void main(String[] args) {
        // Pedimos los valores al comprador del servicio, 1.Creando el scanner
        Scanner Valores = new Scanner(System.in);
        // Creamos un ciclo try-catch para verificar que los datos sean unicamente numeros.
        boolean Numeros = false;

        double Distancia_Comprador = 0;
        double Carga_Comprador = 0;

        while(!Numeros) {
            try {
                System.out.print("Ingrese el valor de la distancia en kilometros: ");
                Distancia_Comprador = Valores.nextDouble();

                System.out.print("Ingrese el valor de la carga en kilogramos: ");
                Carga_Comprador = Valores.nextDouble();
                
                Numeros = true;
            } catch(Exception Letras) {
                System.out.println("Por favor ingrese un valor numerico valido.");
                Valores.nextLine();
                continue;
            }
        }

        Costo_Moto Precio_Final = new Costo_Moto();
        double Costo_Viaje = Precio_Final.CalcularCosto(Distancia_Comprador, Carga_Comprador);
                
        // Importamos dos librerias, una para pesos colombianos 
        // La otra para que ajuste puntos decimales y el simbolo de moneda.
        Locale Colombia = new Locale("es", "CO");
        NumberFormat Formato = NumberFormat.getCurrencyInstance(Colombia);
        
        System.out.println("El costo del viaje en moto es: " + Formato.format(Costo_Viaje) + " COP");
       // Calculamos el tiempo usando la clase 
    Tiempo_Viaje Tiempo = new Tiempo_Viaje();
    double Tiempo_Viaje_Moto = Tiempo.CalcularTiempo(Distancia_Comprador);

    // 1. Convertimos todo el tiempo en horas a minutos totales
    int minutosTotales = (int) (Tiempo_Viaje_Moto * 60);

// 2. Calculamos las horas completas (división entera)
int horas = minutosTotales / 60;

// 3. Calculamos los minutos restantes usando el operador módulo (%)
int minutos = minutosTotales % 60;

// 4. Imprimimos el resultado con printf usando %d para números enteros (sin decimales)
System.out.printf("El tiempo estimado del viaje es: %d horas y %d minutos\n", horas, minutos);
        Valores.close(); 
    }
}
