package mx.unam.dgtic.alumnocrud.repository;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlumnoPagingAndSortingRepository extends PagingAndSortingRepository<Alumno, String>{
}
