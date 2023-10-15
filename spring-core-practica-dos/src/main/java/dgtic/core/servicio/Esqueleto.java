package dgtic.core.servicio;

public class Esqueleto implements Enemigo{
    private Integer visibilidad;

    @Override
    public void dibujar() {
        System.out.println("Dibujando Esqueleto");
    }
}
