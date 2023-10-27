package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Transaccion;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.TransaccionRepositorio;

import java.util.List;
import java.util.Optional;

public class TransaccionRepositorioImpl implements TransaccionRepositorio {

    @Override
    public List<Transaccion> findAll() {
        return BaseDeDatos.transacciones;
    }

    @Override
    public List<Transaccion> findByMontoGreaterThan(int monto) {
        List<Transaccion> montos = BaseDeDatos.transacciones.stream().filter(t -> t.getMonto() > monto).toList();
        return montos;
    }

    @Override
    public List<Transaccion> findByMonto(int monto) {
        List<Transaccion> montos = BaseDeDatos.transacciones.stream().filter(t -> t.getMonto() == monto).toList();
        return montos;
    }

    @Override
    public Transaccion findById(String id) {
        Optional<Transaccion> transaccionOptional = BaseDeDatos.transacciones.stream().filter(t -> t.getId().equals(id)).findFirst();
        Transaccion transaccion = null;
        if (transaccionOptional.isPresent()){
            transaccion = transaccionOptional.orElseThrow();
        }
        return transaccion;
    }
}
