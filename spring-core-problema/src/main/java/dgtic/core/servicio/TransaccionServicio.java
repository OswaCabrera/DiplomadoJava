package dgtic.core.servicio;

import dgtic.core.modelo.Transaccion;

import java.util.List;

public interface TransaccionServicio {
    public List<Transaccion> findAll();

    public List<Transaccion> findByMontoGreaterThan(int monto);

    public  List<Transaccion> findByMonto(int monto);

    public Transaccion findById(String id);
}
