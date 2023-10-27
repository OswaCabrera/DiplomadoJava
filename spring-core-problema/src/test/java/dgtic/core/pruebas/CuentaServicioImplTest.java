package dgtic.core.pruebas;

import dgtic.core.modelo.Cuenta;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.CuentaRepositorio;
import dgtic.core.servicio.CuentaServicio;
import dgtic.core.servicio.CuentaServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CuentaServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class CuentaServicioImplTest {
    @Mock
    private CuentaRepositorio cuentaRepositorio;

    @InjectMocks
    private CuentaServicioImpl cuentaServicio;

    @Test
    void testUno() {
        when(cuentaRepositorio.findAll()).thenReturn(BaseDeDatos.cuentas);
        assertEquals(2, cuentaRepositorio.findAll().size());
        assertEquals(2, cuentaServicio.findAll().size());
    }

    @Test
    void testDos(){
        when(cuentaRepositorio.findAll()).thenReturn(BaseDeDatos.cuentas);
        List<Cuenta> cuentas = cuentaServicio.findAll();
        assertEquals(2, cuentas.size());
        assertEquals("Nueva", cuentas.get(0).getEstatusCuenta().getNombre());
        assertSame(cuentas.get(0).getEstatusCuenta(), cuentas.get(1).getEstatusCuenta());
    }

    @Test
    void testTres(){
        when(cuentaRepositorio.findBySaldoGreaterThan(0)).thenReturn(BaseDeDatos.cuentas.stream().toList().stream().filter(e->e.getSaldo()>0).toList());
        List<Cuenta> cuenta = cuentaRepositorio.findBySaldoGreaterThan(0);
        assertNotNull(cuenta);
        assertEquals(1, cuenta.size(), "Una cuenta está con 0");
    }


    @Test
    void testCuatro() {
        when(cuentaRepositorio.findBySaldo(500)).thenReturn(BaseDeDatos.cuentas.stream().toList().stream().filter(e->e.getSaldo()==500).toList());
        List<Cuenta> cuenta = cuentaRepositorio.findBySaldo(500);
        assertNotNull(cuenta);
        assertEquals(1, cuenta.size(), "Una cuenta tiene 500 y la otra 1000");
    }

    @Test
    void testCinco(){
        when(cuentaRepositorio.findByDate("2021-05-01")).thenReturn(BaseDeDatos.cuentas.stream().toList().stream().filter(e->e.getFechaApertura().equals("2021-05-01")).toList());
        List<Cuenta> cuenta = cuentaServicio.findByDate("2021-05-01");
        assertNotNull(cuenta);
        assertEquals(0, cuenta.size(), "Bien");
    }



}
