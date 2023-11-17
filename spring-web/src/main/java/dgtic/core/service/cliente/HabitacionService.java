package dgtic.core.service.cliente;

import dgtic.core.model.entity.HabitacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HabitacionService {
    Page<HabitacionEntity> findAll(Pageable pageable);
    void guardar(HabitacionEntity habitacionEntity);
    void borrar(Integer id);
    HabitacionEntity buscarHabitacionId(Integer id);
}
