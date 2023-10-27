package dgtic.core.servicio;

import dgtic.core.modelo.Transaccion;
import dgtic.core.repositorio.intf.TransaccionRepositorio;

import java.util.List;
import java.util.Optional;

public class TransaccionServicioImpl implements TransaccionServicio{

    private TransaccionRepositorio transaccionRepositorio;

    public TransaccionServicioImpl(TransaccionRepositorio transaccionRepositorio) {
        super();
        this.transaccionRepositorio = transaccionRepositorio;
    }

    @Override
    public List<Transaccion> findAll() {
        return transaccionRepositorio.findAll();
    }

    @Override
    public List<Transaccion> findByMontoGreaterThan(int monto) {
        List<Transaccion> montos = transaccionRepositorio.findByMontoGreaterThan(monto);
        return montos;
    }

    public  List<Transaccion> findByMonto(int monto){
        List<Transaccion> montos = transaccionRepositorio.findByMonto(monto);
        return montos;
    }

    @Override
    public Transaccion findById(String id) {
        Transaccion transaccion = transaccionRepositorio.findById(id);
        return transaccion;
    }
}
