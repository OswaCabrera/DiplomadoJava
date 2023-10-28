package mx.unam.dgtic.alumnocrud.sesion4;

import mx.unam.dgtic.alumnocrud.infoTester;
import mx.unam.dgtic.alumnocrud.model.Calificacion;
import mx.unam.dgtic.alumnocrud.repository.CalificacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ConsultaCalificacionesTest {

    @Autowired
    CalificacionRepository calificacionRepository;

    @Test
    void buscarCalificacionesByMateria(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar por POO");
        ArrayList<Calificacion> resultado = (ArrayList<Calificacion>) calificacionRepository.findByMateria("POO");
        resultado.forEach(System.out::println);
    }
}
