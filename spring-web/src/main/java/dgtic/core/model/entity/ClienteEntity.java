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

@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_cte;
    @NotEmpty(message = "Nombre no debe ser vacío")
    @Column(length = 30)
    private String nombre;
    @NoEspacioNoVacio
    @Column(name="apellido_paterno",length = 30)
    private String apellidoPaterno;
    @Column(name="tarjeta_credito",length = 20)
    @Pattern(regexp="[0-9]{10,10}|[0-9]{13,13}",message = "Tarjeta el tamaño debe ser 10 ó 13 dígitos")
    private String tarjetaCredito;
    @Column(length = 40)
    @NotEmpty(message = "Correo no vacío")
    @Email(message = "Formato incorrecto de correo")
    private String correo;
    @Column(length = 10)
    @Size(min = 10,max = 10,message = "Teléfono debe ser de 10 dígitos")
    @Pattern(regexp="55[0-9]{8,8}")
    private String telefono;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false,
            mappedBy = "cliente"
    )
    private Set<ReservacionEntity> reservaciones;





}
