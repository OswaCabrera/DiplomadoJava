package dgtic.core.pruebas;

import dgtic.core.repositorio.intf.EstatusCuentaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import dgtic.core.repositorio.BaseDeDatos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {EstatusServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class EstatusServicioImplTest {
    private EstatusCuentaRepositorio estatusRepositorio;

    @BeforeEach
    public void inicio() {
        estatusRepositorio=mock(EstatusCuentaRepositorio.class);
    }

    @Test
    void testUno() {
        when(estatusRepositorio.findAll()).thenReturn(BaseDeDatos.estatusCuenta);
        assertEquals(2, estatusRepositorio.findAll().size());
    }

    @Test
    void testDos() {
        when(estatusRepositorio.findByNombre("Nueva")).thenReturn(BaseDeDatos.estatusCuenta.stream()
                .filter(e->e.getNombre().equals("Nueva"))
                .findFirst()
                .get());
        assertEquals("Nueva", estatusRepositorio.findByNombre("Nueva ").getNombre());
    }

}
