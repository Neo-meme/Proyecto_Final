public class Dron extends Aereos {
    /*
     Usamos la opcion Final en las variables, para que estas no puedan ser modificadas, es decir, que su valor se mantenga constante a lo largo del programa.
     Esto es útil para definir características fijas de cada tipo de vehículo.
    */

    private static final double velocidad = 72; // Velocidad promedio en km/h
    private static final double capacidad_carga = 100; // Capacidad de carga en kg
    private static final double distancia_maxima = 69; // Distancia máxima en km

    public Dron( ) {
        super(velocidad, capacidad_carga, distancia_maxima);
    }

  @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 2000 + carga * 1200;
    }

}
    