package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Usuario;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.UsuarioRepositorio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    @Override
    public List<Usuario> findAll() {
        return BaseDeDatos.usuarios;
    }

    @Override
    public Usuario findByNombre(String nombre) {
        Optional<Usuario> usuarioOptional = this.findAll().stream()
                .filter(u -> u.getNombre().contains(nombre)).findFirst();
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.orElseThrow();
        }
        return usuario;
    }

    @Override
    public Usuario findByNombreAndPassword(String nombre, String password) {
        Optional<Usuario> usuarioOptional = this.findAll().stream()
                .filter(u -> u.getNombre().contains(nombre) && u.getPassword().contains(password)).findFirst();
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.orElseThrow();
        }
        return usuario;
    }

    @Override
    public Usuario crear() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml"});
        Usuario usuarioNuevo = (Usuario)context.getBean("usuario");
        ((ClassPathXmlApplicationContext) context).close();
        return usuarioNuevo;
    }

    @Override
    public String obtenerCorreoPorTelefono(String telefono) {
        for (Usuario usuario : BaseDeDatos.usuarios) {
            if (usuario.getTelefono().equals(telefono)) {
                return usuario.getEmail();
            }
        }
        return null;
    }

}
