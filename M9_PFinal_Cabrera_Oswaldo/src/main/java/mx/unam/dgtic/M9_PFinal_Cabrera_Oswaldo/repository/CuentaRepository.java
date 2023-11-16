package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CuentaRepository extends CrudRepository<Cuenta, String> {
    List<Cuenta> findAll();
    Cuenta save(Cuenta cuenta);
    void delete(Cuenta cuenta);
    Cuenta findById(Integer id);

    List<Cuenta> findBySaldoGreaterThan(Integer saldo);
    List<Cuenta> findByFechaAperturaAfter(Date fecha);
    List<Cuenta> findBySaldoGreaterThanAndFechaAperturaAfter(Integer saldo, Date fecha);

    List<Cuenta> findByEstatusAndSaldoGreaterThan(Integer estatus, Integer saldo);

    List<Cuenta> buscarTodasCuentas();
    List<Cuenta> buscarCuentaYTransacciones(Integer id);


}

