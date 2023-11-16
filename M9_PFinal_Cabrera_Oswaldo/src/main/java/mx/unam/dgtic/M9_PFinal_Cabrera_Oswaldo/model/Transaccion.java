package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
@NamedQuery(
        name = "Transaccion.buscarTodasTransaccionesConCuenta",
        query = "SELECT t FROM Transaccion t JOIN FETCH t.cuenta_id"
)
public class Transaccion {
    @Id
    @Column(name = "transaccion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer monto;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta_id;

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", cuenta_id=" + cuenta_id +
                '}';
    }
}
