package dgtic.core.repository;

import dgtic.core.model.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CuentaRepository extends JpaRepository<CuentaEntity,Integer> {
    @Query("SELECT c FROM cuenta c WHERE c.usuario.id_usuario=?1")
    CuentaEntity buscarCuentaUsuarioId(Integer id);
}
