package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Transaccion {
    @Id
    private Integer transaccion_id;
    private Integer moonto;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta_id;
}
