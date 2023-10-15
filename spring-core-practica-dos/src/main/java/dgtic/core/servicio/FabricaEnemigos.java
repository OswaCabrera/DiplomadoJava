package dgtic.core.servicio;

import dgtic.core.modelo.TipoEnemigo;

public class FabricaEnemigos {
    private static FabricaEnemigos fabricaEnemigos = new FabricaEnemigos();

    public static FabricaEnemigos getInstance() {
        return fabricaEnemigos;
    }

    public Enemigo getEnemigo(TipoEnemigo tipo) {
        if (tipo.equals(TipoEnemigo.CATACUMBAS)) {
            return new Catacumbas();
        } else if (tipo.equals(TipoEnemigo.MEDUSAS)) {
            return new Medusas();
        } else if (tipo.equals(TipoEnemigo.ESQUELETO)) {
            return new Esqueleto();
        } else {
            throw new IllegalArgumentException("Tipo de enemigo no soportado");
        }
    }
}
