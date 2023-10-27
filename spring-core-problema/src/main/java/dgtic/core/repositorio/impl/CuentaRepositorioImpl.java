package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Cuenta;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.CuentaRepositorio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CuentaRepositorioImpl implements CuentaRepositorio {

    @Override
    public List<Cuenta> findAll() {
        return BaseDeDatos.cuentas;
    }

    @Override
    public List<Cuenta> findBySaldoGreaterThan(Integer saldo) {
        List<Cuenta> cuentas=BaseDeDatos.cuentas.stream()
                .filter(c->c.getSaldo()>saldo)
                .toList();
        return cuentas;
    }

    @Override
    public List<Cuenta> findByDate(String date) {
        List<Cuenta> cuentas=BaseDeDatos.cuentas.stream()
                .filter(c->c.getFechaApertura().after(Date.from(new Date().toInstant().minusSeconds(86400)))).toList();
        return cuentas;
    }

    @Override
    public List<Cuenta> findBySaldo(Integer saldo) {
        List<Cuenta> cuentas=BaseDeDatos.cuentas.stream()
                .filter(c->c.getSaldo()==saldo)
                .toList();
        return cuentas;
    }


}
