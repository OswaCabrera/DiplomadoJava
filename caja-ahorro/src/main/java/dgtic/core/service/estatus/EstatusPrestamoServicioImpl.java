package dgtic.core.service.estatus;

import dgtic.core.model.entity.EstatusPrestamoEntity;
import dgtic.core.repository.EstatusPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusPrestamoServicioImpl implements EstatusPrestamosService {

    @Autowired
    private EstatusPrestamoRepository estatusPrestamoRepository;

    @Override
    public List<EstatusPrestamoEntity> buscarEstatusPrestamos() {
        return estatusPrestamoRepository.findAll();
    }

    @Override
    public EstatusPrestamoEntity buscarEstatusPrestamoId(Integer id) {
        return estatusPrestamoRepository.findById(id).get();
    }
}
