package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "El número de mensualidades no debe ser vacio")
    private Integer mensualidades;

    @NotNull(message = "El interes no debe ser vacio")
    private Integer interes;

    @NotNull(message = "El monto no debe ser vacio")
    @Column(name = "monto_original")
    private Integer monto;

    @Column(name = "monto_pagar")
    private Integer montoFinal;

    @Column(name = "fecha_peticion")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "estatus_prestamos_id")
    private EstatusPrestamoEntity estatusPrestamosId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
