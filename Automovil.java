public class Automovil extends Terrestres {
    /*
     Usamos la opcion Final en las variables, para que estas no puedan ser modificadas, es decir, que su valor se mantenga constante a lo largo del programa.
     Esto es útil para definir características fijas de cada tipo de vehículo.
    */

    private static final double velocidad = 70.0; // Velocidad promedio en km/h
    private static final double capacidad_carga = 3500; // Capacidad de carga en Kg siendo la conversion de 3.5 toneladas a kg
    private static final double distancia_maxima = 300; // Distancia máxima en km

    public Automovil( ) {
        super( velocidad, capacidad_carga,distancia_maxima);
    }

    @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 400 + carga * 50;
    }

    @Override
    public String toString() {
        return "Automovil";
    }
    
}