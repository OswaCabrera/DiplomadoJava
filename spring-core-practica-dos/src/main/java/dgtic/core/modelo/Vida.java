package dgtic.core.modelo;

public class Vida {
    private String nombreJugador;
    private Integer numeroVida;
    private Integer continues;

    public Vida() {
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Integer getNumeroVida() {
        return numeroVida;
    }

    public void setNumeroVida(Integer numeroVida) {
        this.numeroVida = numeroVida;
    }

    public Integer getContinues() {
        return continues;
    }

    public void setContinues(Integer continues) {
        this.continues = continues;
    }

    @Override
    public String toString() {
        return "Vida{" +
                "nombreJugador='" + nombreJugador + '\'' +
                ", numeroVida=" + numeroVida +
                ", continues=" + continues +
                '}';
    }
}
