package dgtic.core.service.reservacion;

import dgtic.core.model.entities.ReservacionEntity;
import dgtic.core.repository.ReservacionRepository;
import dgtic.core.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservacionServiceImpl implements ReservacionService {

    @Autowired
    ReservacionRepository reservacionRepository;

    @Override
    public Page<ReservacionEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void guardar(ReservacionEntity reservacion) {
        reservacionRepository.save(reservacion);
    }

    @Override
    public void borrar(Integer id) {

    }

    @Override
    public ReservacionEntity buscarReservacionId(Integer id) {
        return null;
    }

    @Override
    public List<ReservacionEntity> buscarReservacion() {
        return null;
    }

    @Override
    public List<ReservacionEntity> buscarReservacionPatron(String nombre) {
        String[] nm=nombre.split(" ");
        return reservacionRepository.findByNombreFecha(nm[0]);
    }
}
