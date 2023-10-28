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
