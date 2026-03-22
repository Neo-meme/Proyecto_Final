public class Camion extends Terrestres {
      
    private static final double velocidad = 60; // Velocidad promedio en km/h
    private static final double capacidad_carga = 31000; // Capacidad de carga en Kg (31 toneladas)
    private static final double distancia_maxima = 800; // Distancia máxima en km

    public Camion() {
        super(velocidad, capacidad_carga, distancia_maxima);
    }

    @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 600 + carga * 100; // Fórmula de costo para el camión
    }

    @Override
    public String toString() {
        return "Camion";
    
}
