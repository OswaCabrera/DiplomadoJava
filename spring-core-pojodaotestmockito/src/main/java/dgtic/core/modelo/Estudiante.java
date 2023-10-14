package dgtic.core.modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class Estudiante {	
	private String matricula;
	private String nombre;
	private int edad;
	private List<Materia> materias=new ArrayList<>();	
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}
	public Estudiante(String matricula, String nombre, int edad) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.edad = edad;		
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public List<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(Materia ...materias ) {
		this.materias.addAll(Arrays.asList(materias));
	}
	@Override
	public String toString() {
		return "Estudiante [matricula=" + matricula + ", nombre=" + nombre + ", edad=" + edad + ", materias=" + materias
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(edad, materias, matricula, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return edad == other.edad && Objects.equals(materias, other.materias)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nombre, other.nombre);
	}
}
