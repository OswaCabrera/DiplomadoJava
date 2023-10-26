package dgtic.core.servicio;

import dgtic.core.modelo.Transaccion;
import dgtic.core.repositorio.intf.TransaccionRepositorio;

import java.util.List;

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
}
