package dgtic.core.service.estatus;

import dgtic.core.model.entity.EstatusCuentaEntity;

import java.util.List;

public interface EstatusCuentaService {
    List<EstatusCuentaEntity> buscarEstatusCuentas();

    EstatusCuentaEntity buscarEstatusCuentaId(Integer id);

}
