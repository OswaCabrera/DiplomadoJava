package dgtic.core.repositorio.intf;
import java.util.List;
import dgtic.core.modelo.Estudiante;
public interface EstudianteRepositorio {
	public List<Estudiante> findAll();
	public Estudiante findById(String matricula);
	public void save(Estudiante estudiante);
}
