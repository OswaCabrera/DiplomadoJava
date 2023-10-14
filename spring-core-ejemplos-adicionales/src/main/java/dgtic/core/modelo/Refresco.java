package dgtic.core.modelo;

public class Refresco extends Producto{
    private double capacidad;

    @Override
    public String toString() {
        return "Refresco{" +
                "capacidad=" + capacidad + " " + super.toString() + super.toString() +
                '}';
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public Refresco() {
    }
}
