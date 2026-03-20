public class Camion extends Terrestres {

    public Camion(String marca, String modelo, double velocidad, double capacidad_carga) {
        super(marca, modelo, velocidad, capacidad_carga);
    }

    @Override
    public double CalcularCosto(double distancia, double carga) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalcularCosto'");
    }

    @Override
    public double CalcularTiempo(double distancia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalcularTiempo'");
    }

    @Override
    public double ValidarCarga(double carga) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ValidarCarga'");
    }

}
    