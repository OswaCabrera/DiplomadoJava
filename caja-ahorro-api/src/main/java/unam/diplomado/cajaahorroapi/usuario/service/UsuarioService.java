package unam.diplomado.cajaahorroapi.usuario.service;

import unam.diplomado.cajaahorroapi.usuario.domain.Cuenta;
import unam.diplomado.cajaahorroapi.usuario.domain.Usuario;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario, Cuenta cuenta);
}
