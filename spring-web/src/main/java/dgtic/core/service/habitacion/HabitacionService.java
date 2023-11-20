package dgtic.core.service.habitacion;

import dgtic.core.model.entities.HabitacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HabitacionService {
    Page<HabitacionEntity> findAll(Pageable pageable);
    void guardar(HabitacionEntity habitacion);
    void borrar(Integer id);
    HabitacionEntity buscarHabitacionlId(Integer id);
    List<HabitacionEntity> buscarHabitacion();
    List<HabitacionEntity> buscarHabitacionPatron(String patron);

    List<HabitacionEntity> buscarHabitacionHotel(String hotel);
}
