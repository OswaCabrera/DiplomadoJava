package mx.unam.dgtic.alumnocrud.model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "calificaciones")
public class Calificacion {
    @Id
    private int id;
    private String materia;
    private int calificacion;
    //private String alumnosMatricula;
    @ManyToOne
    @JoinColumn(name = "alumnos_matricula")
    private Alumno alumno;

}
