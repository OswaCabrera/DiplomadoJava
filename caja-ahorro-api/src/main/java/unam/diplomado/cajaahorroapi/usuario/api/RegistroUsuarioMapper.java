package unam.diplomado.cajaahorroapi.usuario.api;

import org.springframework.stereotype.Component;
import unam.diplomado.cajaahorroapi.usuario.domain.Cuenta;
import unam.diplomado.cajaahorroapi.usuario.domain.Usuario;

@Component
public class RegistroUsuarioMapper {
    public Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return new Usuario(
                usuarioRequestDTO.getNombre(),
                usuarioRequestDTO.getApellidoPaterno(),
                usuarioRequestDTO.getApellidoMaterno(),
                usuarioRequestDTO.getEmail(),
                usuarioRequestDTO.getPassword(),
                usuarioRequestDTO.getNumeroTelefonico(),
                usuarioRequestDTO.getRol()
        );
    }

    public Cuenta toCuenta(CuentaDTO cuentaDTO) {
        return new Cuenta(
                cuentaDTO.getSaldo(),
                cuentaDTO.getFechaApertura(),
                cuentaDTO.getEstatusCuenta()
        );
    }

    public UsuarioResponseDTO toDto(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre() + " " +
                usuario.getApellidoPaterno() + " " +
                usuario.getApellidoMaterno(),
                usuario.getEmail()
        );
    }
}
