package dgtic.core.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private String Nombre;

    @Column(length = 40, name = "apellido_paterno")
    @NotBlank(message = "Apellido paterno no debe ser vacio")
    private String apellidoPaternio;

    @Column(length = 40, name = "apellido_materno")
    @NotBlank(message = "Apellido materno no debe ser vacio")
    private String apellidoMaternio;

    @Column(length = 100)
    @NotBlank(message = "Correo no debe ser vacio")
    @Email
    private  String email;

    @Column(length = 250)
    @NotBlank(message = "La contraseña no debe ser vacia")
    private String password;

    private Integer rol_id;

}
