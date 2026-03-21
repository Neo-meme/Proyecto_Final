public class Dron extends Aereos {

    private static final double velocidad = 72.0; // Velocidad promedio en km/h
    private static final double capacidad_carga = 100; // Capacidad de carga en kg

    public Dron( ) {
        super(velocidad, capacidad_carga);
    }

  @Override
    public double CalcularCosto(double distancia, double carga) {
        return distancia * 2 + carga * 0.1;
    }

}
    