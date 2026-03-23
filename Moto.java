public class Moto extends Terrestres {
    /*
     Usamos la opcion Final en las variables, para que estas no puedan ser modificadas, es decir, que su valor se mantenga constante a lo largo del programa.
     Esto es útil para definir características fijas de cada tipo de vehículo.
    */

    private static final double velocidad = 90; // Velocidad promedio en km/h
    private static final double capacidad_carga = 1000; // Capacidad de carga en Kg
    private static final double distancia_maxima = 200; // Distancia máxima en km

    public Moto( ) {
        super( velocidad, capacidad_carga,distancia_maxima);
    }

    @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 200 + carga * 20;
    }           

    @Override
    public double calcularHuella(double distancia, double carga) {
        return distancia * 50 + carga * 2  ;
    }

    @Override
    public String toString() {
        return "Moto";
    }
    
}


