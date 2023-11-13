package dgtic.core.model.entity;

import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cte;
    @Column(length = 30)
    @NotBlank
    private String nombre;
    @Column(length = 30, name = "apellido_paterno")
    @NoEspacioNoVacio
    private String apellidoPaterno;
    @Column(length = 20, name = "tarjeta_credito")
    @NotBlank(message = "Tarjeta de crédito no debe estar vacío")
    @Pattern(regexp = "[0-9]{10,10}|[0-9]{13,13}", message = "Tarjeta no válida")
    private String tarjetaCredito;
    @Column(length = 40)
    @NotBlank(message = "Correo no debe estar vacío")
    @Email
    private String correo;
    @Column(length = 10)
    @NotBlank(message = "Teléfono no debe estar vacío")
    @Size(min = 10,max = 10,message = "Teléfono debe ser de 10 dígitos")
    @Pattern(regexp = "55[0-9]{8,8}") //empieza con 55, tiene dígitos del 0 al 9 y tiene longitud min 8 max 8
    private String telefono;


}