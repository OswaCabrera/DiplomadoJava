package dgtic.core.modelo;

public class Libro {
    private String isbn;
    private String nombre;

    public Libro(String isbn, String nombre) {
        this.isbn = isbn;
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
