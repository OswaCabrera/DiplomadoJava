package mx.unam.dgtic.alumnocrud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    private String matricula;
    private String nombreAlumno;

    private String paterno;
    private Date fnac;
    private double estatura;
}
