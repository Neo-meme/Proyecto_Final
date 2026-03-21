public class Camion extends Terrestres {

    public static final double velocidad = 70.0; // Velocidad promedio en km/h
    public static final double capacidad_carga = 31000; // Capacidad de carga en Kg siendo la conversion de 31 tonelada a kg

    public Camion( double velocidad, double capacidad_carga) {
        super( velocidad, capacidad_carga);
    }

   @Override
    public double CalcularCosto(double distancia, double carga) {
        return distancia * 0.5 + carga * 0.2;
    }

}
    