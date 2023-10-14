package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Estudiante {

    private String matricula;

    private String nombre;
    private Integer edad;

    private List<Materia> materias = new ArrayList<>();

    public Estudiante(String matricula, String nombre, Integer edad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Estudiante() {
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Materia ... materias) {
        this.materias = Arrays.asList(materias);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", materias=" + materias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante that)) return false;
        return Objects.equals(getMatricula(), that.getMatricula()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getEdad(), that.getEdad()) && Objects.equals(getMaterias(), that.getMaterias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula(), getNombre(), getEdad(), getMaterias());
    }
}
