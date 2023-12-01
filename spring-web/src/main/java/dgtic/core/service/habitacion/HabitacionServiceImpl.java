package dgtic.core.service.habitacion;

import dgtic.core.model.entity.HabitacionEntity;
import dgtic.core.repository.HabitacionRepository;
import dgtic.core.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl implements HabitacionService{
    @Autowired
    HabitacionRepository habitacionRepository;
    @Override
    public Page<HabitacionEntity> findAll(Pageable pageable) {

        return habitacionRepository.findAll(pageable);
    }

    @Override
    public void guardar(HabitacionEntity habitacion) {

        habitacionRepository.save(habitacion);
    }

    @Override
    public void borrar(Integer id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public HabitacionEntity buscarHabitacionlId(Integer id) {
        Optional<HabitacionEntity> op=habitacionRepository.findById(id);
        return op.get();
    }

    @Override
    public List<HabitacionEntity> buscarHabitacion() {
        return habitacionRepository.findAll();
    }

    @Override
    public List<HabitacionEntity> buscarHabitacionPatron(String patron) {
        return null;
    }

    @Override
    public List<HabitacionEntity> buscarHabitacionHotel(String hotel) {
        return habitacionRepository.findByHotel(hotel);
    }
}
