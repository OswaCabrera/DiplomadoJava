package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cuenta")
@NamedQuery(
        name= "Cuenta.buscarTodasCuentas",
        query = "SELECT distinct c FROM Cuenta c JOIN FETCH c.usuario_id"
)
@NamedNativeQuery(
        name = "Cuenta.buscarCuentaYTransacciones",
        query = "SELECT c.*, t.transaccion_id FROM cuenta c JOIN transaccion t ON (c.cuenta_id = t.cuenta_id) WHERE c.cuenta_id = :id",
        resultClass = Cuenta.class
)
public class Cuenta {
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer saldo;
    @Column(name = "fecha_apertura")
    private Date fechaApertura;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;
    @Column(name = "estatus_cuenta_id")
    private Integer estatus;
    @OneToMany(mappedBy = "cuenta_id")
    @Transient
    private List<Transaccion> transaccion_id;

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                ", usuario_id=" + usuario_id +
                ", estatus=" + estatus +
                '}';
    }
}
