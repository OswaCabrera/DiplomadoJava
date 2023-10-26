package dgtic.core.repositorio.impl;

import dgtic.core.modelo.EstatusCuenta;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.EstatusCuentaRepositorio;

import java.util.List;
import java.util.Optional;

public class EstatusCuentaRepositorioImpl implements EstatusCuentaRepositorio {
    @Override
    public List<EstatusCuenta> findAll() {
        return BaseDeDatos.estatusCuenta;
    }

    @Override
    public EstatusCuenta findByNombre(String nombre) {
        Optional<EstatusCuenta> estatusCuentaOptional = BaseDeDatos.estatusCuenta.stream()
                .filter(e -> e.getNombre().contains(nombre)).findFirst();
        EstatusCuenta estatusCuenta = null;
        if (estatusCuentaOptional.isPresent()) {
            estatusCuenta = estatusCuentaOptional.orElseThrow();
        }
        return estatusCuenta;
    }

}
