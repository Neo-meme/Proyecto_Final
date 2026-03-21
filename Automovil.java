public class Automovil extends Terrestres {

    public static final double velocidad = 60.0; // Velocidad promedio en km/h
    public static final double capacidad_carga = 3500; // Capacidad de carga en Kg siendo la conversion de 3.5 toneladas a kg

    public Automovil( ) {
        super( velocidad, capacidad_carga);
    }

    @Override
    public double CalcularCosto(double distancia, double carga) {
        return distancia * 0.5 + carga * 0.2;
    }
    
}