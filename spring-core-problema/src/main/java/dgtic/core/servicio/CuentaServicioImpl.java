package dgtic.core.servicio;

import dgtic.core.modelo.Cuenta;
import dgtic.core.repositorio.intf.CuentaRepositorio;

import java.util.List;
import java.util.Optional;

public class CuentaServicioImpl implements CuentaServicio{

    private CuentaRepositorio cuentaRepositorio;

    public CuentaServicioImpl(CuentaRepositorio cuentaRepositorio) {
        super();
        this.cuentaRepositorio = cuentaRepositorio;
    }
    @Override
    public List<Cuenta> findAll() {
        return cuentaRepositorio.findAll();
    }

    @Override
    public Cuenta findBySaldo(Integer saldo) {
        Optional<Cuenta> cuentaOptional=cuentaRepositorio.findAll().stream()
                .filter(c->c.getSaldo().equals(saldo))
                .findFirst();
        Cuenta cuenta=null;
        if(cuentaOptional.isPresent()){
            cuenta=cuentaOptional.orElseThrow();
        }
        return cuenta;
    }
}
