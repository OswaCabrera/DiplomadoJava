package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Estudiante;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.BaseDeDatosDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDeDatosDao")
public class BaseDeDatosDAOImpl implements BaseDeDatosDao {

    @Override
    public List<Estudiante> getEstudiantes(String carrera) {
        return BaseDeDatos.carreras.get(carrera);
    }

    @Override
    public Estudiante getEstudiante(String carrera, String matricula) {
        return BaseDeDatos.carreras.get(carrera).stream().filter(e->e.getMatricula().equals(matricula)).findFirst().get();
    }
}
