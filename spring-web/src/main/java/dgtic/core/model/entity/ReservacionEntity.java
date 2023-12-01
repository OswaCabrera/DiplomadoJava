package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "reservacion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ReservacionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_rsv;
    @Column(name = "fecha_reservacion")
    private Date fechaReservacion;
    @Column(name = "fecha_inicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    private Date fechaTermino;
    @Column(name = "total_dias")
    private int totalDias;
    @ManyToOne
    @JoinColumn(name = "id_cte")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name="id_hbt",nullable = true)
    private HabitacionEntity habitacion;
}
