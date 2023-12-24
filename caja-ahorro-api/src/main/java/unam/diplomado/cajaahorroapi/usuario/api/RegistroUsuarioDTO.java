package unam.diplomado.cajaahorroapi.usuario.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroUsuarioDTO {
    @NotNull(message="Usuario es requerido para realizar el registro")
    @Valid
    private UsuarioRequestDTO usuario;

    @NotNull(message="Cuenta es requerida para realizar el registro")
    @Valid
    private CuentaDTO cuenta;
}
