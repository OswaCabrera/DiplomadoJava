package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
}
