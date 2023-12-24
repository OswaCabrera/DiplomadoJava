package unam.diplomado.cajaahorroapi.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorroapi.usuario.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
