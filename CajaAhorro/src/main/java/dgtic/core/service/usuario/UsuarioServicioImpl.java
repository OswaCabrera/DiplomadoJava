package dgtic.core.service.usuario;

import dgtic.core.model.entity.UsuarioEntity;
import dgtic.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<UsuarioEntity> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public void guardar(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void borrar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioEntity buscarUsuarioId(Integer id) {
        Optional<UsuarioEntity> op = usuarioRepository.findById(id);
        return op.get();
    }
}
