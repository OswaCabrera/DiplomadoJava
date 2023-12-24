package unam.diplomado.cajaahorroapi.usuario.domain;

public class EstatusCuentaNotFoundException extends RuntimeException{
    public EstatusCuentaNotFoundException(Integer estatusCuenta) {
        super("No existe el estatusCuenta: " + estatusCuenta);
    }
}
