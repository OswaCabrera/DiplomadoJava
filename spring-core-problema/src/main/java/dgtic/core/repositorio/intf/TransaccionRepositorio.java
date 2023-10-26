package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Transaccion;

import java.util.List;

public interface TransaccionRepositorio {
    public List<Transaccion> findAll();
}
