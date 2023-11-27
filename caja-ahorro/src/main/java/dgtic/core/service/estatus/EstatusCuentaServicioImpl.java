package dgtic.core.service.estatus;

import dgtic.core.model.entity.EstatusCuentaEntity;
import dgtic.core.repository.EstatusCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusCuentaServicioImpl implements EstatusCuentaService {
    @Autowired
    private EstatusCuentaRepository estatusCuentaRepository;
    @Override
    public List<EstatusCuentaEntity> buscarEstatusCuentas() {
        return estatusCuentaRepository.findAll();
    }

    @Override
    public EstatusCuentaEntity buscarEstatusCuentaId(Integer id) {
        return estatusCuentaRepository.findById(id).get();
    }
}
