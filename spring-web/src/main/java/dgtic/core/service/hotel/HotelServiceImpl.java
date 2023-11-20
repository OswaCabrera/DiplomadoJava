package dgtic.core.service.hotel;

import dgtic.core.model.entities.HotelEntity;
import dgtic.core.repository.HotelRepository;
import dgtic.core.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;


    @Override
    public Page<HotelEntity> findAll(Pageable pageable) {

        return hotelRepository.findAll(pageable);
    }

    @Override
    public void guardar(HotelEntity hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void borrar(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public HotelEntity buscarHotelId(Integer id) {
        Optional<HotelEntity> op= hotelRepository.findById(id);
        return op.get();
    }

    @Override
    public List<HotelEntity> buscarHotel() {

        return hotelRepository.findAll();
    }

    @Override
    public List<HotelEntity> buscarHotelPatron(String patron) {
        return hotelRepository.findByNombre(patron);

    }
}
