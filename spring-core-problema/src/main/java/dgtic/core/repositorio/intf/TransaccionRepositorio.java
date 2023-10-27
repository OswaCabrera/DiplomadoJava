package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Transaccion;

import java.util.List;

public interface TransaccionRepositorio {
    public List<Transaccion> findAll();

    public List<Transaccion> findByMontoGreaterThan(int monto);

    public  List<Transaccion> findByMonto(int monto);

    public Transaccion findById(String id);
}
