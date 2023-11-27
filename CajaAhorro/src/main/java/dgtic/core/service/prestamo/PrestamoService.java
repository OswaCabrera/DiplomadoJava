package dgtic.core.service.prestamo;

import dgtic.core.model.entity.PrestamoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrestamoService {
    Page<PrestamoEntity> findAll(Pageable pageable);
    void guardar(PrestamoEntity prestamo);
    void borrar(Integer id);
    PrestamoEntity buscarPrestamoId(Integer id);

}
