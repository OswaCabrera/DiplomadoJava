package dgtic.core.servicio;

import dgtic.core.modelo.EstatusCuenta;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.EstatusCuentaRepositorio;

import java.util.List;
import java.util.Optional;

public class EstatusCuentaServicioImpl implements EstatusCuentaServicio{

    private EstatusCuentaRepositorio estatusCuentaRepositorio;

    public EstatusCuentaServicioImpl(EstatusCuentaRepositorio estatusCuentaRepositorio) {
        super();
        this.estatusCuentaRepositorio = estatusCuentaRepositorio;
    }

    @Override
    public List<EstatusCuenta> findAll() {
        return estatusCuentaRepositorio.findAll();
    }

    @Override
    public EstatusCuenta findByNombre(String nombre) {
        Optional<EstatusCuenta> estatusCuentaOptional = this.estatusCuentaRepositorio.findAll().stream()
                .filter(e -> e.getNombre().contains(nombre)).findFirst();
        EstatusCuenta estatusCuenta = null;
        if (estatusCuentaOptional.isPresent()) {
            estatusCuenta = estatusCuentaOptional.orElseThrow();
        }
        return estatusCuenta;
    }
}
