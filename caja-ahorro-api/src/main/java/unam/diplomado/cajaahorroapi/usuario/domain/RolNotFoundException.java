package unam.diplomado.cajaahorroapi.usuario.domain;

public class RolNotFoundException extends RuntimeException{
    public RolNotFoundException(Integer rol) {
        super("No existe el rol: " + rol);
    }
}
