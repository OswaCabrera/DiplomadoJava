package dgtic.core.servicio;

public class Catacumbas implements Enemigo{
    private Integer experiencia;
    @Override
    public void dibujar() {
        System.out.println("Dibujando Catacumbas");
    }
}
