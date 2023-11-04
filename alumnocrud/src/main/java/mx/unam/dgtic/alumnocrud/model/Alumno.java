package mx.unam.dgtic.alumnocrud.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumnos")
//Namaed Queries
@NamedQuery(name="Alumno.buscarAltos",
    query="SELECT a FROM Alumno a WHERE a.estatura > 1.60")

@NamedQuery(name="Alumno.buscarElGarrocha",
    query="SELECT a FROM Alumno a WHERE a.estatura = (SELECT MAX(a.estatura) FROM Alumno a)")

//buscar estatura maxima, regresa un double
@NamedQuery(name="Alumno.buscarEstaturaMaxima",
    query="SELECT MAX(a.estatura) FROM Alumno a")

@NamedQuery(name="Alumno.buscarAltosConFecha",
    query="SELECT a FROM Alumno a WHERE a.estatura > 1.70 AND a.fnac > :fecha")

@NamedQuery(name="Alumno.buscarAltosConFechaDos",
    query="SELECT a FROM Alumno a WHERE a.estatura > ?1 AND a.fnac > ?2")

@NamedQuery(name="Alumno.buscarAltosConFechaTres",
        query="SELECT a FROM Alumno a WHERE a.estatura > :estatura AND a.fnac > :fecha")

@NamedQuery(name="Alumno.buscarAltosMayorPromedio",
        query="SELECT a FROM Alumno a WHERE a.estatura > (SELECT AVG(a.estatura) FROM Alumno a)"
)

@NamedNativeQuery(
        name = "Alumno.nnqBuscarAltoPromedio",
        query = "SELECT a.* FROM alumnos as a WHERE a.estatura > (SELECT AVG(estatura) FROM alumnos) ",
        resultClass = Alumno.class
)

@NamedNativeQuery(
        name = "Alumno.nnqBuscarAlumnoCalificacion",
        query = "SELECT * FROM alumnos as a JOIN calificaciones as c ON (a.matricula = c.alumnos_matricula) " +
                " WHERE a.matricula = :matricula",
        resultClass = Alumno.class
)

public class Alumno {
    @Id
    private String matricula;
    @Column(name = "nombre_alumno")
    private String nombreAlumno;

    private String paterno;
    private Date fnac;
    private double estatura;

    @OneToMany(fetch=FetchType.EAGER ,mappedBy = "alumno")
    private List<Calificacion> calificaciones = new ArrayList<>();

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombreAlumno='" + nombreAlumno + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", estatura=" + estatura +
                '}';
    }
}
