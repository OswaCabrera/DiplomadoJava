package mx.unam.dgtic.alumnocrud.sesion4;

import mx.unam.dgtic.alumnocrud.infoTester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class CalificacionesAlumnoTest {
    @Test
    @Sql({"/schema_al_cal.sql","/data.sql"})
    void loadCalsAlumnos(){
        System.out.println(infoTester.NOMBRE);
    }
}
