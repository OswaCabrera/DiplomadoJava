package dgtic.core.servicio;

import dgtic.core.modelo.TipoCarro;

public class FabricaCoches {
    private static FabricaCoches fabricaCoches = new FabricaCoches();

    public static FabricaCoches getInstance() {
        return fabricaCoches;
    }

    public ModeloCoche getModeloCoche(TipoCarro tipo){
        if(tipo.equals(TipoCarro.DEPORTIVO)) {
            return new Deportivo();
        } else if(tipo.equals(TipoCarro.FAMILIAR)) {
            return new Familiar();
        } else if(tipo.equals(TipoCarro.TODOTERRENO)) {
            return new TodoTerreno();
        }
        throw new IllegalArgumentException("Tipo de carro no soportado");
    }

}
