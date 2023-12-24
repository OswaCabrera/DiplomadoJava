package unam.diplomado.cajaahorroapi.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorroapi.usuario.domain.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
