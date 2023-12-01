package dgtic.core.repository;


import dgtic.core.model.entity.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Integer> {
    @Query("select p from habitacion p where p.hotel.id_htl=?1")
    public List<HabitacionEntity> findByHotel(String dato);
}
