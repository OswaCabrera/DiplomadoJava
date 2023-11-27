package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "cuenta")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CuentaEntity {
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    private Integer saldo;

    @Column(name = "fecha_apertura")
    private Date fechaApertura;

    @ManyToOne
    @JoinColumn(name = "estatus_cuenta_id")
    private EstatusCuentaEntity estatus;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

}
