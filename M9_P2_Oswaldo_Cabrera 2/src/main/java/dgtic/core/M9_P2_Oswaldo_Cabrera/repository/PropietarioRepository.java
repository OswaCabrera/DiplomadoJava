package dgtic.core.M9_P2_Oswaldo_Cabrera.repository;

import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Automovil;
import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Propietario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropietarioRepository extends CrudRepository<Propietario, Integer> {
    //create a new propietario
    Propietario save(Propietario propietario);

    //Consultas derivadas
    List<Propietario> findPropietarioByNombreEndingWith(String nombre);

    Integer countPropietarioByNombreEndingWith(String nombre);

    List<Propietario> findPropietarioByIdBetween(Integer id1, Integer id2);

    List<Propietario> findPropietarioByTelefonoIsNull();

    List<Propietario> findPropietarioByTelefonoNotNull();
}
