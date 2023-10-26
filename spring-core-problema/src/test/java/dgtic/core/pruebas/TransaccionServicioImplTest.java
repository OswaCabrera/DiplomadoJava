package dgtic.core.pruebas;

import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.TransaccionRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {TransaccionServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class TransaccionServicioImplTest {
    private TransaccionRepositorio transaccionRepositorio;

    @BeforeEach
    public void inicio() {
        transaccionRepositorio=mock(TransaccionRepositorio.class);
    }

    @Test
    void testUno() {
        when(transaccionRepositorio.findAll()).thenReturn(BaseDeDatos.transacciones);
        assertEquals(2, transaccionRepositorio.findAll().size());
    }

}
