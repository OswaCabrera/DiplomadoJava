package dgtic.core.modelo;
import java.util.Objects;
import dgtic.core.excepciones.CreditosMenores;
public class Materia {
	private Long id;
	private String nombre;
	private Integer creditos;
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	
	public Materia(Long id, String nombre, Integer creditos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		if(creditos<0) {
			throw new CreditosMenores("No creditos negativos");
		}else {
			this.creditos = creditos;
		}
		
	}
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", creditos=" + creditos + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(creditos, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(creditos, other.creditos) && Objects.equals(nombre, other.nombre);
	}
		
}
