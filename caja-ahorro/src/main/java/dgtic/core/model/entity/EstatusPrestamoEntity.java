package dgtic.core.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "estatus_prestamos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstatusPrestamoEntity {
    @Id
    @Column(name = "estatus_prestamos_id")
    private Integer idEstatusPrestamo;

    private String nombre;

    private String descripcion;

}
