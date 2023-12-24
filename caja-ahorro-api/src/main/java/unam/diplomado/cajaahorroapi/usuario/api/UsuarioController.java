package unam.diplomado.cajaahorroapi.usuario.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import unam.diplomado.cajaahorroapi.usuario.domain.Cuenta;
import unam.diplomado.cajaahorroapi.usuario.domain.Usuario;
import unam.diplomado.cajaahorroapi.usuario.service.UsuarioService;

@RestController
public class UsuarioController implements UsuarioApi {

    @Autowired
    private RegistroUsuarioMapper mapper;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UsuarioResponseDTO registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        Usuario usuario = mapper.toUsuario(registroUsuarioDTO.getUsuario());
        Cuenta cuenta = mapper.toCuenta(registroUsuarioDTO.getCuenta());
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario, cuenta);
        return mapper.toDto(usuarioCreado);
    }
}
