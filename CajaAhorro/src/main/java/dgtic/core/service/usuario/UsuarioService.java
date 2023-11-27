package dgtic.core.service.usuario;

import dgtic.core.model.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    Page<UsuarioEntity> findAll(Pageable pageable);
    void guardar(UsuarioEntity usuario);
    void borrar(Integer id);
    UsuarioEntity buscarUsuarioId(Integer id);

}
