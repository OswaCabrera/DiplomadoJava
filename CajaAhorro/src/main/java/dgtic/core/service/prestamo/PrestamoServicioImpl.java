package dgtic.core.service.prestamo;

import dgtic.core.model.entity.PrestamoEntity;
import dgtic.core.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrestamoServicioImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public Page<PrestamoEntity> findAll(Pageable pageable) {
        return prestamoRepository.findAll(pageable);
    }

    @Override
    public void guardar(PrestamoEntity prestamo) {
        prestamoRepository.save(prestamo);
    }

    @Override
    public void borrar(Integer id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public PrestamoEntity buscarPrestamoId(Integer id) {
        Optional<PrestamoEntity> op = prestamoRepository.findById(id);
        return op.get();
    }
}
