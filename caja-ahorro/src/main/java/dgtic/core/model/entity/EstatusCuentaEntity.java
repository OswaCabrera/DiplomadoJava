package dgtic.core.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "estatus_cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstatusCuentaEntity {
    @Id
    @Column(name = "estatus_cuenta_id")
    private Integer idEstatusCuenta;

    private String nombre;

    private String descripcion;
}
