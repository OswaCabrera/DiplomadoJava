package dgtic.core.M9_P2_Oswaldo_Cabrera.repository;

import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Automovil;
import org.springframework.data.repository.CrudRepository;

public interface AutomovilRepository extends CrudRepository<Automovil, Integer> {
    //create a new automovil
    Automovil save(Automovil automovil);
}
