package dgtic.core.repository;


import dgtic.core.model.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer> {
    @Query("select p from hotel p where p.nombre like %?1%")
    public List<HotelEntity> findByNombre(String dato);
}
