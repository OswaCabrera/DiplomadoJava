package dgtic.core.M9_P2_Oswaldo_Cabrera;

import dgtic.core.M9_P2_Oswaldo_Cabrera.model.Automovil;
import dgtic.core.M9_P2_Oswaldo_Cabrera.repository.AutomovilRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VehiculoCrudBasicoTest {

    @Autowired
    private AutomovilRepository automovilRepository;

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

}
