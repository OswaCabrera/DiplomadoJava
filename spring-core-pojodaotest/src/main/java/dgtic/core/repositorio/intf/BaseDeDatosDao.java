package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Estudiante;

import java.util.List;

public interface BaseDeDatosDao {
    public List<Estudiante> getEstudiantes(String carrera);
    public Estudiante getEstudiante(String carrera, String matricula);

}
