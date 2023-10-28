package mx.unam.dgtic.alumnocrud.model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "calificaciones")
public class Calificacion {
    @Id
    private Integer id;
    private String materia;
    private int calificacion;
    //private String alumnosMatricula;
    @ManyToOne
    @JoinColumn(name = "alumnos_matricula")
    private Alumno alumno;

    @Override
    public String toString() {
        return "Materia Info: " +
                "\n- ID: " + id +
                "\n- Materia: " + materia +
                "\n- Calificación: " + calificacion +
                "\n- " + (alumno != null ? alumno.toString() + "\n" : "No asignado");
    }
}
