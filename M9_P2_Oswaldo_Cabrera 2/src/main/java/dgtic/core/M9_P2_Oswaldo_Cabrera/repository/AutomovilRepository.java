package dgtic.core.M9_P2_Oswaldo_Cabrera.repository;

import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Automovil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutomovilRepository extends CrudRepository<Automovil, Integer> {
    //create a new automovil
    Automovil save(Automovil automovil);
    Automovil findAutomovilByMatricula(String matricula);

    List<Automovil> findAll();
    Automovil findAutomovilById(Integer id);
    List<Automovil> findAllById(Iterable<Integer> ids);

    //Consultas derivadas
    List<Automovil> findAutomovilByAnio(Integer anio);

    List<Automovil> findAutomovilByMatriculaContainingAndAnio(String matricula, Integer anio);

    List<Automovil> findAutomovilByAnioNot(Integer anio);

    List<Automovil> findAllByOrderByAnioAsc();

}
