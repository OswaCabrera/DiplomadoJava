package unam.diplomado.cajaahorroapi.usuario.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CuentaDTO {
    private Integer saldo;
    private Date fechaApertura;
    private Integer estatusCuenta;
}
