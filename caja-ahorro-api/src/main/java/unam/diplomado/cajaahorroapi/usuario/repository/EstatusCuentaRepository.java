package unam.diplomado.cajaahorroapi.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorroapi.usuario.domain.EstatusCuenta;

public interface EstatusCuentaRepository extends JpaRepository<EstatusCuenta, Integer> {
}
