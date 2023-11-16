package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository;

import jakarta.persistence.NamedNativeQuery;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
    Usuario findById(Integer id);
    Usuario findByContrasenaAndEmail(String password, String email);

    List<Object[]> buscarTodosUsuariosConCuentas();

    Usuario buscarUsuarioyCuenta(Integer id);

}
