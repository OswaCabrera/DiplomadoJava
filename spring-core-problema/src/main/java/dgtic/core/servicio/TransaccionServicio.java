package dgtic.core.servicio;

import dgtic.core.modelo.Transaccion;

import java.util.List;

public interface TransaccionServicio {
    public List<Transaccion> findAll();
}
