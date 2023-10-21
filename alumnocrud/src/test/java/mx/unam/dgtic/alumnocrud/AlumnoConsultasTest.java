package mx.unam.dgtic.alumnocrud;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import mx.unam.dgtic.alumnocrud.repository.ALumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AlumnoConsultasTest {

    @Autowired
    ALumnoRepository alumnoRepository;


    @Test
    void seleccionarTodos(){
        System.out.println("Seleccionando a todos los alumnos");
        System.out.println("Seleccionando a todos los alumnos");
        List<Alumno> alumnos = (List<Alumno>) alumnoRepository.findAll();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    @Test
    void buscarUnoTest(){
        System.out.println("Buscando a un alumno");
        Optional<Alumno> resultado = alumnoRepository.findById("1A");
        System.out.println(resultado);
    }

    @Test
    void insertaUnoTest(){
        System.out.println("Insertando a un alumno");
        Alumno alumno = new Alumno("1E", "Juan", "Perez", Date.valueOf("1956-01-01"), 1.70);
        Alumno resultado = alumnoRepository.save(alumno);
        System.out.println(resultado);
    }
}