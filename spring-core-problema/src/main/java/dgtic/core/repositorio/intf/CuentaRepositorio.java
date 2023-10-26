package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Cuenta;

import java.util.List;

public interface CuentaRepositorio {
    public List<Cuenta> findAll();

    public Cuenta findBySaldo(Integer saldo);
}
