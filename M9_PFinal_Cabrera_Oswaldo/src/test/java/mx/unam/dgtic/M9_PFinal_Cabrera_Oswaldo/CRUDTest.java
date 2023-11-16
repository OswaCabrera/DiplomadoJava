package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Usuario;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CRUDTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void seleccionarTodos(){
        System.out.println(InfoTester.NOMBRE);
        usuarioRepository.findAll().forEach(System.out::println);
    }

    @Test
    void guardarUsuario(){
        System.out.println(InfoTester.NOMBRE);
        Usuario usuario = new Usuario();
        usuario.setNombre("Oswaldo");
        usuario.setApellidoPaterno("Cabrera");
        usuario.setApellidoMaterno("Garcia");
        usuario.setEmail("oswaldo@hola.com");
        usuario.setContrasena("1234");
        usuario.setRol_id(1);
        usuario.setNumeroTelefonico("5512345678");
        usuario.setZip(12345);
        usuario.setEstado("CDMX");
        usuario.setCalle("Empedrado");
        usuario.setContrasena("1234");
        usuarioRepository.save(usuario);
        System.out.println(usuario);
    }

    @Test
    void actualizarUsuario(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println(usuarioRepository.findById(1));
        Usuario user = usuarioRepository.findById(1);
        user.setNombre("Oswaldo");
        usuarioRepository.save(user);
        System.out.println(usuarioRepository.findById(1));
    }


    @Test
    void eliminarUsuario(){
        System.out.println(InfoTester.NOMBRE);
        Usuario usuario = usuarioRepository.findByContrasenaAndEmail( "password1", "user1@example.com");
        usuarioRepository.delete(usuario);
    }

}
