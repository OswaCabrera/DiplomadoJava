package dgtic.core.servicio;
import java.util.List;
import dgtic.core.modelo.Estudiante;
public interface EstudianteServicio {
	public List<Estudiante> findAll();
	public Estudiante findById(String matricula);
	public String archivoCSV(String matricula);
	public int creditos(String matricula);
}