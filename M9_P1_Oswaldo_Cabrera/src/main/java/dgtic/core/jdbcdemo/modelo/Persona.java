package dgtic.core.jdbcdemo.modelo;

public class Persona {
    private int idpersona;
    private String nombre;
    private int edad;

    public Persona() {
    }

    public Persona(int idpersona, String nombre, int edad) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idpersona=" + idpersona +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public static class Producto {
    }
}
