package dgtic.core.repository;

import dgtic.core.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository  extends JpaRepository<ClienteEntity,Integer> {
    @Query("select p from cliente p where p.nombre like %?1%")
    public List<ClienteEntity> findByNombre(String dato);
}
