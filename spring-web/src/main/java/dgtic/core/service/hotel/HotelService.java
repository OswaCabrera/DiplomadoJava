package dgtic.core.service.hotel;

import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.model.entity.HotelEntity;
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
