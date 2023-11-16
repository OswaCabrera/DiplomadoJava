package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Transaccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransaccionRepository extends CrudRepository<Transaccion, String> {
    List<Transaccion> findAll();
    Transaccion save(Transaccion transaccion);
    void delete(Transaccion transaccion);
    Transaccion findById(Integer id);

    List<Transaccion> buscarTodasTransaccionesConCuenta();

    @Query(
            value = "INSERT INTO transaccion (fecha, monto, estatus_transaccion_id, tipo_transaccion_id, cuenta_id) VALUES (?,?,?,?,?)",
            nativeQuery = true
    )
    void nativeInsertTransaccion(Date fecha, Integer monto, int estatus_transaccion_id, Integer tipo_transaccion_id, Integer cuenta_id);

    @Query(
            value = "UPDATE transaccion SET monto = :monto, estatus_transaccion_id = :estatus_transaccion_id WHERE transaccion_id = :transaccion_id",
            nativeQuery = true
    )
    void nativeUpdateMontoyEstatus(Integer monto, Integer estatus_transaccion_id,Integer transaccion_id);

    @Query(
            value = "DELETE FROM transaccion WHERE transaccion_id = ?",
            nativeQuery = true
    )
    void deleteTransaccion(Integer transaccion_id);

    @Query(
            value = ("UPDATE transaccion SET estatus_transaccion_id = ? WHERE transaccion_id = ?"),
            nativeQuery = true
    )
    void updateEstatus(Integer estatus_transaccion_id, Integer transaccion_id);
}
