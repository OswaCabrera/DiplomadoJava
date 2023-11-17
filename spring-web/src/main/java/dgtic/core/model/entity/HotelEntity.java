package dgtic.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class HotelEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_htl;
    @Column(length = 50)
    @NoEspacioNoVacio
    private String nombre;
    @Column(name="direccion",length = 100)
    @NoEspacioNoVacio
    private String direccion;
    @Column
    private int clasificacion;
    @Column(length = 40)
    @NotEmpty(message = "Correo no debe ser vacío")
    @Email(message = "Formato incorrecto de correo")
    private String correo;
    @Column(length = 10)
    @Size(min = 10,max = 10,message = "Teléfono debe ser de 10 dígitos")
    @Pattern(regexp="[1-9]{2,2}[0-9]{8,8}",message = "Teléfono debe ser de 10 dígitos")
    private String telefono;
    @Column(length = 100)
    private String imagen;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "hotel"
    )
    private Set<HabitacionEntity> habitacionSet;
}
