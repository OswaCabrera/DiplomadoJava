package dgtic.core.M9_P2_Oswaldo_Cabrera.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "propietarios")
public class Propietario {
    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    @ManyToOne
    @JoinColumn(name = "automovil_id")
    private Automovil automovil;
}
