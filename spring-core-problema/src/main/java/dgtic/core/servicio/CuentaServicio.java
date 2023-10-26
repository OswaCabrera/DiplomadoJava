package dgtic.core.servicio;

import dgtic.core.modelo.Cuenta;

import java.util.List;

public interface CuentaServicio {
    public List<Cuenta> findAll();

   public Cuenta findBySaldo(Integer saldo);


}
