package dgtic.core.service.reservacion;

import dgtic.core.model.entities.HotelEntity;
import dgtic.core.model.entities.ReservacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservacionService {
    Page<ReservacionEntity> findAll(Pageable pageable);
    void guardar(ReservacionEntity reservacion);
    void borrar(Integer id);
    ReservacionEntity buscarReservacionId(Integer id);
    List<ReservacionEntity> buscarReservacion();
    List<ReservacionEntity> buscarReservacionPatron(String nombre);

}
