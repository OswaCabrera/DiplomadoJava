package unam.diplomado.cajaahorroapi.usuario.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="api/usuarios", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public interface UsuarioApi {

    @PostMapping(path="registro", consumes=MediaType.APPLICATION_JSON_VALUE)
    UsuarioResponseDTO registrarUsuario(
            @NotNull @Valid @RequestBody RegistroUsuarioDTO registroUsuarioDTO);
}
