public abstract class Vehiculo {

    protected double velocidad;
    protected double capacidad_carga;
    protected double distancia_maxima;

    public Vehiculo(double velocidad, double capacidad_carga, double distancia_maxima) {
        this.velocidad = velocidad;
        this.capacidad_carga = capacidad_carga;
        this.distancia_maxima = distancia_maxima;
    }

    // Método abstracto (cada vehículo lo define)
    public abstract double calcularCosto(double distancia, double carga);

    // Método general
    public double calcularTiempo(double distancia) {
        return distancia / velocidad;
    }
    /* Los métodos de validación de carga y distancia
        no son Abstractos porque la validación de carga y distancia es igual para todos los vehículos ya que se limitaron para facilitrar el ejercicio,
        por lo que no es necesario obligar a las subclases a implementarla.
    */
    
    //seccion de Validaciones, compueba si la carga y la distancia están dentro de los límites del vehículo
    public boolean validarCarga(double carga) {
        return carga <= capacidad_carga;
    }

    public boolean validarDistancia(double distancia) {
        return distancia <= distancia_maxima;
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

    public double getDistancia_maxima() {
        return distancia_maxima;
    }

    public void setDistancia_maxima(double distancia_maxima) {
        this.distancia_maxima = distancia_maxima;
    }

}