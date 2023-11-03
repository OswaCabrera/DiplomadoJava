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
public class VehiculoCrudBasicoTest {

    @Autowired
    private AutomovilRepository automovilRepository;

    @Autowired
    PropietarioRepository propietarioRepository;

    @Test
    void crearAutomovilTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Crear automovil");
        Automovil automovil = new Automovil();
        automovil.setMarca("Honda");
        automovil.setModelo("City");
        automovil.setAnio(2010);
        automovil.setMatricula("DGTIC-001");
        System.out.println(automovilRepository.save(automovil));
    }

    @Test
    void asignarAutomovilTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Asignar automovil");
        Automovil automovil = automovilRepository.findAutomovilByMatricula("DGTIC-001");
        Propietario propietario = new Propietario();
        propietario.setNombre("Julián López");
        propietario.setDireccion("Calle 10");
        propietario.setTelefono("5544554455");
        propietario.setEmail("julian@hotmail.com");
        propietario.setAutomovil(automovil);
        propietarioRepository.save(propietario);
    }

    @Test
    void mostrarTodosAutomovilesTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Mostrar todos los automoviles");
        automovilRepository.findAll().forEach(System.out::println);
    }

    @Test
    void actualizarPropietario(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Actualizar propietario");
        Propietario propietario = propietarioRepository.findById(4).get();
        propietario.setNombre("Lucy Hernandez");
        propietarioRepository.save(propietario);
        System.out.println(propietarioRepository.findById(4).get());
    }

    @Test
    void encontrarAutomovilId(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Encontrar automovil por id");
        System.out.println(automovilRepository.findAutomovilById(5));
    }

    @Test
    void encontrarPorIterable(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Encontrar automovil por iterable");
        automovilRepository.findAllById(List.of(1, 3, 5)).forEach(System.out::println);
    }


}
