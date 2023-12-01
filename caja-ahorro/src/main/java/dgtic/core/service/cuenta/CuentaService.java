package dgtic.core.service.cuenta;

import dgtic.core.model.entity.CuentaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CuentaService {
    Page<CuentaEntity> findAll(Pageable pageable);
    void guardar(CuentaEntity cuenta);
    void borrar(CuentaEntity cuenta);
    CuentaEntity buscarCuentaId(Integer id);

    CuentaEntity buscarCuentaUsuarioId(Integer id);
}
