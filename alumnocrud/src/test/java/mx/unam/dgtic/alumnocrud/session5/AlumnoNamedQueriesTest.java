package mx.unam.dgtic.alumnocrud.session5;

import mx.unam.dgtic.alumnocrud.infoTester;
import mx.unam.dgtic.alumnocrud.repository.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlumnoNamedQueriesTest {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Test
    void buscarAltosTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar alumnos altos");
        alumnoRepository.buscarAltos().forEach(System.out::println);
    }

}
