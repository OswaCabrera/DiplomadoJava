package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Cuenta;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.CuentaRepositorio;

import java.util.List;
import java.util.Optional;

public class CuentaRepositorioImpl implements CuentaRepositorio {

    @Override
    public List<Cuenta> findAll() {
        return BaseDeDatos.cuentas;
    }

    @Override
    public Cuenta findBySaldo(Integer saldo) {
        Optional<Cuenta> cuentaOptional=BaseDeDatos.cuentas.stream()
                .filter(c->c.getSaldo().equals(saldo))
                .findFirst();
        Cuenta cuenta=null;
        if(cuentaOptional.isPresent()){
            cuenta=cuentaOptional.orElseThrow();
        }
        return cuenta;
    }


}
