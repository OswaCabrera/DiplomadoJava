package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "prestamo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PrestamoEntity {
    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idPrestamo;

    private Integer mensualiadades;

    private Integer interes;

    private Integer monto;

    @Column(name = "monto_pagar")
    private Integer montoFinal;

    @Column(name = "fecha_peticion")
    private Date fecha;

    private Integer estatus_prestamos_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
