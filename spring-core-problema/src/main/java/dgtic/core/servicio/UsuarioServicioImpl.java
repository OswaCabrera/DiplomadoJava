package dgtic.core.servicio;

import dgtic.core.modelo.Usuario;
import dgtic.core.repositorio.intf.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario findByNombre(String nombre) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findAll().stream()
                .filter(u -> u.getNombre().contains(nombre)).findFirst();
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.orElseThrow();
        }
        return usuario;
    }

    @Override
    public Usuario findByNombreAndPassword(String nombre, String password) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findAll().stream()
                .filter(u -> u.getNombre().contains(nombre) && u.getPassword().contains(password)).findFirst();
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.orElseThrow();
        }
        return usuario;
    }

    @Override
    public Usuario crear() {
        return usuarioRepositorio.crear();
    }

    @Override
    public String obtenerCorreoPorTelefono(String telefono) {
        return usuarioRepositorio.obtenerCorreoPorTelefono(telefono);
    }
}
