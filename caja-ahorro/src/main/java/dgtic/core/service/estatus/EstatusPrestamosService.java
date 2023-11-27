package dgtic.core.service.estatus;

import dgtic.core.model.entity.EstatusPrestamoEntity;

import java.util.List;

public interface EstatusPrestamosService {
    List<EstatusPrestamoEntity> buscarEstatusPrestamos();

    EstatusPrestamoEntity buscarEstatusPrestamoId(Integer id);
}
