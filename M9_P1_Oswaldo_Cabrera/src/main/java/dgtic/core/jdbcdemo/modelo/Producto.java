package dgtic.core.jdbcdemo.modelo;

public class Producto {
    private int id;
    private String descripcion;
    private int precio;
    private int stiock;

    public Producto() {
    }

    public Producto(int id, String descripcion, int precio, int stiock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stiock = stiock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStiock() {
        return stiock;
    }

    public void setStiock(int stiock) {
        this.stiock = stiock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stiock=" + stiock +
                '}';
    }
}
