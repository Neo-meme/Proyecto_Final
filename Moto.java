public class Moto extends Terrestres {

    private static final double velocidad = 90; // Velocidad promedio en km/h
    private static final double capacidad_carga = 1000; // Capacidad de carga en Kg
    private static final double distancia_maxima = 200; // Distancia máxima en km

    public Moto() {
        super(velocidad, capacidad_carga, distancia_maxima);
    }

    @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 300 + carga * 30; // Fórmula de costo para la moto
    }

    @Override
    public String toString() {
        return "Moto";
    
}
