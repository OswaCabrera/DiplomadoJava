package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Transaccion;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.TransaccionRepositorio;

import java.util.List;

public class TransaccionRepositorioImpl implements TransaccionRepositorio {

    @Override
    public List<Transaccion> findAll() {
        return BaseDeDatos.transacciones;
    }
}
