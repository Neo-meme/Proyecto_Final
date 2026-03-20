public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private double velocidad;
    private double capacidad_carga;

    public Vehiculo(String marca, String modelo, double velocidad, double capacidad_carga) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.capacidad_carga = capacidad_carga;
        
    }

    //Funciones abstractas
    public abstract double CalcularCosto(double distancia, double carga);
    public abstract double CalcularTiempo(double distancia);
    public abstract double ValidarCarga(double carga);


    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

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