package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "habitacion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HabitacionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_hbt;
    @Column(length = 50)
    private String nombre;
    @Column
    private boolean refrigerador;
    @Column(name = "numero_camas")
    private int numeroCamas;
    @Column
    private float precio=1.00f;
    @Column(length = 100)
    private String imagen;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_htl")
    private HotelEntity hotel;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "habitacion"
    )
    private Set<ReservacionEntity> reservacionEntitySet;


}
