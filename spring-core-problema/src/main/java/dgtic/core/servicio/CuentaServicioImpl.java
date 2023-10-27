package dgtic.core.servicio;

import dgtic.core.modelo.Cuenta;
import dgtic.core.repositorio.intf.CuentaRepositorio;

import java.util.Date;
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
    public List<Cuenta> findBySaldo(Integer saldo) {
        List<Cuenta> cuentas=cuentaRepositorio.findAll().stream()
                .filter(c->c.getSaldo()==saldo)
                .toList();
        return cuentas;
    }

    @Override
    public List<Cuenta> findBySaldoGreaterThan(Integer saldo) {
        List<Cuenta> cuentas=cuentaRepositorio.findAll().stream()
                .filter(c->c.getSaldo()>saldo)
                .toList();
        return cuentas;
    }

    @Override
    public List<Cuenta> findByDate(String date) {
        List<Cuenta> cuentas=cuentaRepositorio.findAll().stream()
                .filter(c->c.getFechaApertura().after(Date.from(new Date().toInstant().minusSeconds(86400)))).toList();
        return cuentas;
    }
}
