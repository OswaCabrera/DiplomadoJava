package dgtic.core.service.hotel;

import dgtic.core.model.entities.ClienteEntity;
import dgtic.core.model.entities.HotelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HotelService {
    Page<HotelEntity> findAll(Pageable pageable);
    void guardar(HotelEntity hotel);
    void borrar(Integer id);
    HotelEntity buscarHotelId(Integer id);
    List<HotelEntity> buscarHotel();
    List<HotelEntity> buscarHotelPatron(String patron);
}
