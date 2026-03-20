public class Automovil extends Terrestres {

    public Automovil(String marca, String modelo, double velocidad, double capacidad_carga) {
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
    
    /* 
    @Override
    public double calcularCosto(double distancia, double carga) {
        return distancia * 0.5 + carga * 0.2;
    }

    @Override
    public double calcularTiempo(double distancia) {
        return distancia / velocidad;
    }

    public double validarCarga(double carga) {
        if (carga > capacidadCarga) {
            return -1; // Carga no válida
        }
        return carga; // Carga válida
    }
    
    */
}