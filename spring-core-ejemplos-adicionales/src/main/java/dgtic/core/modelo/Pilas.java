package dgtic.core.modelo;

public class Pilas extends Producto{
    private boolean recargables;

    @Override
    public String toString() {
        return "Pilas{" +
                "recargables=" + recargables + " " + super.toString() +
                '}';
    }

    public boolean isRecargables() {
        return recargables;
    }

    public void setRecargables(boolean recargables) {
        this.recargables = recargables;
    }

    public Pilas() {
    }
}
