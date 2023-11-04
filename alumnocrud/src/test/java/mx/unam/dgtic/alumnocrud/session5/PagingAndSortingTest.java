package mx.unam.dgtic.alumnocrud.session5;

import mx.unam.dgtic.alumnocrud.infoTester;
import mx.unam.dgtic.alumnocrud.model.Alumno;
import mx.unam.dgtic.alumnocrud.repository.AlumnoPagingAndSortingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class PagingAndSortingTest {
    @Autowired
    AlumnoPagingAndSortingRepository alumnoPsRepository;

    @Test
    void buscarTodosPorNombrePagingAndSortingTest(){
        System.out.println("Buscar todos");
        System.out.println(alumnoPsRepository.findAll(Sort.by("nombreAlumno").descending()));
    }

    @Test
    void buscarTodosPorNombreYApellidoPagingAndSortingTest(){
        System.out.println("Buscar todos");
        System.out.println(alumnoPsRepository.findAll(Sort.by("nombreAlumno").descending().and(Sort.by("paterno").ascending())));
    }

    @Test
    void findAllOrderByNombrePaternoTypedTest() {
        System.out.println(infoTester.NOMBRE);
        System.out.println("Typed Sort");
        // Se establece el tipo
        Sort.TypedSort<Alumno> typedSort = Sort.sort(Alumno.class);
        Sort configuracion = typedSort.by(Alumno::getNombreAlumno).descending()
                .and(typedSort.by(Alumno::getPaterno).ascending());

        alumnoPsRepository.findAll(configuracion).forEach(System.out::println);
    }

    @Test
    void findAllOrderByNombrePaternoTypedPaginadoTest() {
        System.out.println(infoTester.NOMBRE);
        System.out.println("Typed Sort");
        // Se establece el tipo
        Sort.TypedSort<Alumno> typedSort = Sort.sort(Alumno.class);
        Sort configuracion = typedSort.by(Alumno::getNombreAlumno).ascending()
                .and(typedSort.by(Alumno::getPaterno).ascending());

        //Página 0, 3 elementos por página
        Pageable paginado = PageRequest.of(0, 3, configuracion);
        Page<Alumno> pagina;

        System.out.println("Pagina 0");
        pagina = alumnoPsRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        // segundo ejemplo
        System.out.println("Pagina 1");
        paginado = paginado.next();
        pagina = alumnoPsRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        System.out.println("Pagina 2");
        paginado = paginado.next();
        pagina = alumnoPsRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        System.out.println("Pagina 3");
        paginado = paginado.next();
        pagina = alumnoPsRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        System.out.println("Pagina 4");
        paginado = paginado.next();
        pagina = alumnoPsRepository.findAll(paginado);
        pagina.forEach(System.out::println);

        // automatizar

        paginado = PageRequest.of(0, 3, configuracion);
        System.out.println("------------ Automatizado -----------");
        pagina = alumnoPsRepository.findAll(paginado);
        for (int i = 0; i <= pagina.getTotalPages(); i++) {
            System.out.println("------------ página " + i + "------------");
            pagina.forEach(System.out::println);
            paginado = paginado.next();
            pagina = alumnoPsRepository.findAll(paginado);
        }
    }



}

