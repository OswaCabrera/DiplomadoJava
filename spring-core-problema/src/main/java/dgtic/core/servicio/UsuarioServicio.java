package dgtic.core.servicio;

import dgtic.core.modelo.Usuario;

import java.util.List;

public interface UsuarioServicio {
    public List<Usuario> findAll();
    public Usuario findByNombre(String nombre);
    public Usuario findByNombreAndPassword(String nombre, String password);
    public Usuario crear();
    public String obtenerCorreoPorTelefono(String telefono);
}
