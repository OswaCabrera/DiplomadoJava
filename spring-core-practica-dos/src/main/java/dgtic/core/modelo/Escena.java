package dgtic.core.modelo;

import dgtic.core.servicio.FabricaEnemigos;

public class Escena {
    private String nombre;
    private Integer nivel;
    private Vida vida;

    private FabricaEnemigos enemigos;

    public Escena() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Vida getVida() {
        return vida;
    }

    public void setVida(Vida vida) {
        this.vida = vida;
    }

    public FabricaEnemigos getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(FabricaEnemigos enemigos) {
        this.enemigos = enemigos;
    }

    @Override
    public String toString() {
        return "Escena{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", vida=" + vida +
                '}';
    }
}
