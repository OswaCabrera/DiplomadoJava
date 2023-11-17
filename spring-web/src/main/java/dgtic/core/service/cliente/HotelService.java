package dgtic.core.service.cliente;

import dgtic.core.model.entity.HabitacionEntity;
import dgtic.core.model.entity.HotelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HotelService {
    Page<HotelEntity> findAll(Pageable pageable);
    void guardar(HotelEntity hotelEntity);
    void borrar(Integer id);
    HotelEntity buscarHotelId(Integer id);

}
