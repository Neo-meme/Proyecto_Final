public class Camion extends Terrestres {
    /*
     Usamos la opcion Final en las variables, para que estas no puedan ser modificadas, es decir, que su valor se mantenga constante a lo largo del programa.
     Esto es útil para definir características fijas de cada tipo de vehículo.
    */

    private static final double velocidad = 60; // Velocidad promedio en km/h
    private static final double capacidad_carga = 31000; // Capacidad de carga en Kg (31 toneladas)
    private static final double distancia_maxima = 800; // Distancia máxima en km

    public Camion( ) {
        super( velocidad, capacidad_carga,distancia_maxima);
    }

    @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 600 + carga * 100;
    }

    @Override
    public double calcularHuella(double distancia, double carga) {
        return distancia * 80 + carga * 4 ;
    }

    @Override
    public String toString() {
        return "Automovil";
    }
    
}

