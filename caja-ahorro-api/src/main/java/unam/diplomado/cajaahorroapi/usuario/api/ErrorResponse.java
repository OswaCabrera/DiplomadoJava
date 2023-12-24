package unam.diplomado.cajaahorroapi.usuario.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Integer estatus;
    private String tipo;
    private String mensaje;

}
