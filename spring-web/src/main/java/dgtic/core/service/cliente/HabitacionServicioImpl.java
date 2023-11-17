package dgtic.core.service.cliente;

import dgtic.core.model.entity.HabitacionEntity;
import dgtic.core.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitacionServicioImpl implements HabitacionService{

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public Page<HabitacionEntity> findAll(Pageable pageable) {
        return habitacionRepository.findAll(pageable);
    }

    @Override
    public void guardar(HabitacionEntity habitacionEntity) {
        habitacionRepository.save(habitacionEntity);
    }

    @Override
    public void borrar(Integer id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public HabitacionEntity buscarHabitacionId(Integer id) {
        Optional<HabitacionEntity> habitacionEntityOptional = habitacionRepository.findById(id);
        return habitacionEntityOptional.get();
    }

}
