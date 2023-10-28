package mx.unam.dgtic.alumnocrud;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import mx.unam.dgtic.alumnocrud.repository.ALumnoRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
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

    @Test
    void actualizarUnoTest(){
        System.out.println(infoTester.NOMBRE);
        String matricula = "1E";
        Optional<Alumno> buscado = alumnoRepository.findById(matricula);
        if(buscado.isPresent()){
            buscado.get().setNombreAlumno("Juanito");
            buscado.get().setEstatura(1.80);
            Alumno res = alumnoRepository.save(buscado.get());
            System.out.println("Se modifico el resultado");
            System.out.println(res);
        }else{
            System.out.println("No se encontro el alumno");
        }
    }

    @Test
    void borrarUnoTest(){
        System.out.println(infoTester.NOMBRE);
        String matricula = "1E";
        Alumno alumno = new Alumno();
        alumno.setMatricula(matricula);
        alumnoRepository.delete(alumno);
    }

    @Test
    void borrarUnoTestById(){
        System.out.println(infoTester.NOMBRE);
        String matricula = "1E";
        alumnoRepository.deleteById(matricula);
    }


    @Test
    void buscarVariosTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAllById(List.of("1A","2A","1X"));
        System.out.println(resultado);
    }

    @Test
    void guardarVariosTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> lista = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lista.add(new Alumno(i + "F", "Nombre" + i, "Paterno" + i, Date.valueOf("1956-01-01"), 1.70));
        }
        System.out.println("Registros antes de guardar " + alumnoRepository.count());
        alumnoRepository.saveAll(lista);
        System.out.println("Registros despues de guardar " + alumnoRepository.count());
    }

}