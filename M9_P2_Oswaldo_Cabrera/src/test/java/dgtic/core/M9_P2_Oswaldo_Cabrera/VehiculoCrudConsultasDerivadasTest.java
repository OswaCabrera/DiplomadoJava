package dgtic.core.M9_P2_Oswaldo_Cabrera;

import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Automovil;
import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Propietario;
import dgtic.core.M9_P2_Oswaldo_Cabrera.repository.AutomovilRepository;
import dgtic.core.M9_P2_Oswaldo_Cabrera.repository.PropietarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VehiculoCrudConsultasDerivadasTest {

    @Autowired
    private AutomovilRepository automovilRepository;

    @Autowired
    PropietarioRepository propietarioRepository;

    @Test
    void mostrarAutomovilPorAnio(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar automovil por anio");
        List<Automovil> automoviles = automovilRepository.findAutomovilByAnio(2021);
        automoviles.forEach(System.out::println);
    }

    @Test
    void mostrarPropietarioTerminandoPorApellido(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar propietario terminando por apellido");
        List<Propietario> propietario = propietarioRepository.findPropietarioByNombreEndingWith("EZ");
        propietario.forEach(System.out::println);
    }

    @Test
    void findAutomovilByMatriculaContainingAndAnioTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar automovil por matricula y anio");
        List<Automovil> automoviles = automovilRepository.findAutomovilByMatriculaContainingAndAnio("3", 2020);
        automoviles.forEach(System.out::println);
    }

    @Test
    void findAutomovilByAnioNotTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar automovil por anio not");
        List<Automovil> automoviles = automovilRepository.findAutomovilByAnioNot(2021);
        automoviles.forEach(System.out::println);
    }

    @Test
    void findAllByOrderByAnioAscTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar automovil por anio asc");
        List<Automovil> automoviles = automovilRepository.findAllByOrderByAnioAsc();
        automoviles.forEach(System.out::println);
    }

    @Test
    void countPropietarioByNombreEndingWithTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Contar propietario por nombre ending with");
        Integer propietario = propietarioRepository.countPropietarioByNombreEndingWith("EZ");
        System.out.println(propietario);
    }

    @Test
    void findPropietarioByIdBetweenTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar propietario por id between");
        List<Propietario> propietario = propietarioRepository.findPropietarioByIdBetween(3, 6);
        propietario.forEach(System.out::println);
    }

    @Test
    void findPropietarioByTelefonoIsNullTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar propietario por telefono is null");
        List<Propietario> propietario = propietarioRepository.findPropietarioByTelefonoIsNull();
        propietario.forEach(System.out::println);
    }

    @Test
    void findPropietarioByTelefonoNotNullTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar propietario por telefono is not null");
        List<Propietario> propietario = propietarioRepository.findPropietarioByTelefonoNotNull();
        propietario.forEach(System.out::println);
    }
}
