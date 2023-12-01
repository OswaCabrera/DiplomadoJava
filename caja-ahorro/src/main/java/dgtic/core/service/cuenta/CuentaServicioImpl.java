package dgtic.core.service.cuenta;

import dgtic.core.model.entity.CuentaEntity;
import dgtic.core.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServicioImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Page<CuentaEntity> findAll(Pageable pageable) {
        return cuentaRepository.findAll(pageable);
    }

    @Override
    public void guardar(CuentaEntity cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public void borrar(CuentaEntity cuenta) {
        cuentaRepository.delete(cuenta);
    }

    @Override
    public CuentaEntity buscarCuentaId(Integer id) {
        Optional<CuentaEntity> op = cuentaRepository.findById(id);
        return op.get();
    }

    @Override
    public CuentaEntity buscarCuentaUsuarioId(Integer id) {
        return cuentaRepository.buscarCuentaUsuarioId(id);
    }
}
