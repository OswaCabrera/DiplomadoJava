package dgtic.core.servicio;

import dgtic.core.modelo.Cuenta;

import java.util.List;

public interface CuentaServicio {
    public List<Cuenta> findAll();

   public List<Cuenta> findBySaldo(Integer saldo);

   public List<Cuenta> findBySaldoGreaterThan(Integer saldo);

    public List<Cuenta> findByDate(String date);
}
