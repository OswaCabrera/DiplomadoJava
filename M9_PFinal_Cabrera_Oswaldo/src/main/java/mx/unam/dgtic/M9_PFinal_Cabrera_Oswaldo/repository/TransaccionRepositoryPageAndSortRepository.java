package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Transaccion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaccionRepositoryPageAndSortRepository extends PagingAndSortingRepository <Transaccion, Integer>{
}
