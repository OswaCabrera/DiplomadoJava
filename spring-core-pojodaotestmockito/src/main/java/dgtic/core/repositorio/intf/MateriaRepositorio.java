package dgtic.core.repositorio.intf;
import java.util.List;
import dgtic.core.modelo.Materia;
public interface MateriaRepositorio {
	public List<Materia> findAll();
	public Materia findById(Long id);
	public void save(Materia materia);
}
