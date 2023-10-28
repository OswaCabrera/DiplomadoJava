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
@ToString
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    private String matricula;
    @Column(name = "nombre")
    private String nombreAlumno;

    private String paterno;
    private Date fnac;
    private double estatura;

    @OneToMany(fetch=FetchType.EAGER ,mappedBy = "alumno")
    private List<Calificacion> calificaciones = new ArrayList<>();
}
