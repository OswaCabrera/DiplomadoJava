package unam.diplomado.cajaahorroapi.usuario.api;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioRequestDTO {
    @NotBlank(message="Nombre es requerido")
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @NotBlank(message="Email es requerido")
    private String email;
    @NotBlank(message="Password es requerido")
    private String password;
    private String numeroTelefonico;
    private Integer rol;
}
