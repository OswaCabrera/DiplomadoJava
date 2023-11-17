package dgtic.core.service.cliente;

import dgtic.core.model.entity.HotelEntity;
import dgtic.core.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelServicioImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Page<HotelEntity> findAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    @Override
    public void guardar(HotelEntity hotelEntity) {
        hotelRepository.save(hotelEntity);
    }

    @Override
    public void borrar(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public HotelEntity buscarHotelId(Integer id) {
        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findById(id);
        return hotelEntityOptional.get();
    }
}
