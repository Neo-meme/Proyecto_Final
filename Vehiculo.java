public abstract class Vehiculo {
   private static int contador = 0;
    private String marca;
    private String modelo;
    private int velocidad;
    private int capacidad_carga;

    public Vehiculo(String marca, String modelo, int velocidad, int capacidad_carga) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.capacidad_carga = capacidad_carga;
        
    }

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

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public int getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(int capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }
}