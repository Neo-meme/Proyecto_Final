public class Camion extends Terrestres {
    /*
     Usamos la opcion Final en las variables, para que estas no puedan ser modificadas, es decir, que su valor se mantenga constante a lo largo del programa.
     Esto es útil para definir características fijas de cada tipo de vehículo.
    */

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
    