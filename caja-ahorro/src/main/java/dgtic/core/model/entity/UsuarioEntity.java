package dgtic.core.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioEntity {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 40)
    @NotBlank(message = "Usuario no debe ser vacio")
    private String nombre;

    @Column(length = 40, name = "apellido_paterno")
    @NotBlank(message = "Apellido paterno no debe ser vacio")
    private String apellidoPaterno;

    @Column(length = 40, name = "apellido_materno")
    @NotBlank(message = "Apellido materno no debe ser vacio")
    private String apellidoMaterno;

    @Column(length = 100)
    @NotBlank(message = "Correo no debe ser vacio")
    @Email
    private  String email;

    @Column(length = 250)
    @NotBlank(message = "La contraseña no debe ser vacia")
    private String contrasena;

    @Column(length = 10, name = "numero_telefonico")
    @NotBlank(message = "El número teléfonico no debe ser vacio")
    @Pattern(regexp = "55[0-9]{8,8}")
    private String numeroTelefonico;

    private Integer rol_id;

}
