package dgtic.core.service.prestamo;

import dgtic.core.model.entity.PrestamoEntity;
import dgtic.core.repository.PrestamoRepository;
import dgtic.core.service.estatus.EstatusPrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrestamoServicioImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private EstatusPrestamosService estatusPrestamosService;

    @Override
    public Page<PrestamoEntity> findAll(Pageable pageable) {
        return prestamoRepository.findAll(pageable);
    }

    @Override
    public void guardar(PrestamoEntity prestamo) {
        prestamo.setEstatusPrestamosId(estatusPrestamosService.buscarEstatusPrestamoId(1));
        prestamo.setFecha(new java.util.Date());
        int meses = prestamo.getMensualidades();
        double interes = prestamo.getInteres();
        int monto = prestamo.getMonto();
        double total = monto + (monto * interes/100);
        prestamo.setMontoFinal((int)total);
        prestamoRepository.save(prestamo);
    }

    @Override
    public void borrar(Integer id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public PrestamoEntity buscarPrestamoId(Integer id) {
        Optional<PrestamoEntity> op = prestamoRepository.findById(id);
        return op.get();
    }
}
