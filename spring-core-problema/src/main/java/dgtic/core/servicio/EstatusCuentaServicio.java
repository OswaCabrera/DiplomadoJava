package dgtic.core.servicio;

import dgtic.core.modelo.EstatusCuenta;

import java.util.List;

public interface EstatusCuentaServicio {
    public List<EstatusCuenta> findAll();

    public EstatusCuenta findByNombre(String nombre);
}
