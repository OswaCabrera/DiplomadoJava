package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Cuenta;
import dgtic.core.modelo.EstatusCuenta;

import java.util.List;

public interface EstatusCuentaRepositorio {
    public List<EstatusCuenta> findAll();

    public EstatusCuenta findByNombre(String nombre);
}
