public abstract class Vehiculo {

    private double velocidad;
    private double capacidad_carga;

    public Vehiculo( double velocidad, double capacidad_carga) {
        this.velocidad = velocidad;
        this.capacidad_carga = capacidad_carga;
        
    }

    //Funciones abstractas
    public abstract double CalcularCosto(double distancia, double carga);

    public double CalcularTiempo(double distancia){
        return distancia / velocidad;
    }

    public boolean validarCarga(double carga) {
        return carga <= capacidad_carga;
    }


    //Getters y Setters
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(double capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }
}