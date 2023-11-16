package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Transaccion;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository.TransaccionRepositoryPageAndSortRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class PageAndSortTest {

    @Autowired
    private TransaccionRepositoryPageAndSortRepository transaccionRepositoryPageAndSortRepository;

    @Test
    void findAllTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Typed Sort");
        Sort.TypedSort<Transaccion> typedSort = Sort.sort(Transaccion.class);
        Sort configuration = typedSort.by(Transaccion::getMonto).descending();
        transaccionRepositoryPageAndSortRepository.findAll(configuration).forEach(System.out::println);
    }


    @Test
    void findAllTestPagedTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Typed Sort");
        Sort.TypedSort<Transaccion> typedSort = Sort.sort(Transaccion.class);
        Sort configuration = typedSort.by(Transaccion::getMonto).descending();

        Pageable paginado = PageRequest.of(0, 3, configuration);
        Page<Transaccion> pagina;

        System.out.println("Pagina 0");
        pagina = transaccionRepositoryPageAndSortRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        System.out.println("Pagina 1");
        paginado = paginado.next();
        pagina = transaccionRepositoryPageAndSortRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        System.out.println("Pagina 2");
        paginado = paginado.next();
        pagina = transaccionRepositoryPageAndSortRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        System.out.println("Pagina 3");
        paginado = paginado.next();
        pagina = transaccionRepositoryPageAndSortRepository.findAll(paginado);
        pagina.forEach(System.out::println);
    }
}
