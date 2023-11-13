package mx.unam.dgtic.alumnocrud.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AlumnoCalificacionDTO implements Serializable {
    private String nombreAlumno;
    private String paterno;
    private String materia;
    private int calificacion;
}
