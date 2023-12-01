package dgtic.core.repository;

import dgtic.core.model.entity.ReservacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservacionRepository extends JpaRepository<ReservacionEntity,Integer> {
    @Query("select p from reservacion p where p.cliente.nombre like %?1%")
    public List<ReservacionEntity> findByNombreFecha(String dato);
}
