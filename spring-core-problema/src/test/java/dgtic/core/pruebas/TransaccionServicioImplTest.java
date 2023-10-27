package dgtic.core.pruebas;

import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.CuentaRepositorio;
import dgtic.core.repositorio.intf.TransaccionRepositorio;
import dgtic.core.servicio.TransaccionServicio;
import dgtic.core.servicio.TransaccionServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {TransaccionServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class TransaccionServicioImplTest {
    @Mock
    private TransaccionRepositorio transaccionRepositorio;

    @Mock
    private CuentaRepositorio cuentaRepositorio;
    @InjectMocks
    private TransaccionServicioImpl transaccionServicio;

    @Test
    void testUno(){
        when(transaccionRepositorio.findByMonto(500))
                .thenReturn(BaseDeDatos.transacciones.stream().filter(e -> e.getMonto() == 500).toList());
        when(transaccionRepositorio.findByMonto(1000))
                .thenReturn(BaseDeDatos.transacciones.stream().filter(e -> e.getMonto() == 1000).toList());
        assertEquals(1, transaccionServicio.findByMonto(500).size());
        assertEquals(1, transaccionServicio.findByMonto(1000).size());
    }

    @Test
    void testDos(){
        when(transaccionRepositorio.findById("1"))
                .thenReturn(BaseDeDatos.transacciones.stream().filter(e -> e.getId().equals("1")).findFirst().get());
        when(transaccionRepositorio.findById("2")).thenReturn(BaseDeDatos.transacciones.stream().filter(e -> e.getId().equals("2")).findFirst().get());
        assertEquals("1", transaccionServicio.findById("1").getId());
        assertEquals("2", transaccionServicio.findById("2").getId());
    }

    @Test
    void testTres(){
        when(cuentaRepositorio.findAll()).thenReturn(BaseDeDatos.cuentas);
        when(transaccionRepositorio.findAll()).thenReturn(BaseDeDatos.transacciones);
        assertEquals(1000, transaccionServicio.findAll().get(0).getMonto());
        assertSame(BaseDeDatos.cuentas.get(0), transaccionServicio.findAll().get(0).getCuenta());
    }

    @Test
    void testCuatro() {
        when(transaccionRepositorio.findAll()).thenReturn(BaseDeDatos.transacciones);
        assertEquals(2, transaccionRepositorio.findAll().size());
        assertEquals(2, transaccionServicio.findAll().size());
    }

    @Test
    void testCinco(){
        when(transaccionRepositorio.findByMontoGreaterThan(500))
                .thenReturn(BaseDeDatos.transacciones.stream().filter(e -> e.getMonto() > 500).toList());

        assertEquals(1, transaccionServicio.findByMontoGreaterThan(500).size());
        assertEquals(0, transaccionServicio.findByMontoGreaterThan(1000).size());
    }

}
