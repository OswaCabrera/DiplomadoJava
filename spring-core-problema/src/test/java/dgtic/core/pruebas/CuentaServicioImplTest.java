package dgtic.core.pruebas;

import dgtic.core.modelo.Cuenta;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.CuentaRepositorio;
import dgtic.core.servicio.CuentaServicio;
import dgtic.core.servicio.CuentaServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CuentaServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class CuentaServicioImplTest {
    private CuentaRepositorio cuentaRepositorio;

    @BeforeEach
    public void inicio() {
        cuentaRepositorio=mock(CuentaRepositorio.class);
    }

    @Test
    void testUno() {
        when(cuentaRepositorio.findAll()).thenReturn(BaseDeDatos.cuentas);
        assertEquals(2, cuentaRepositorio.findAll().size());
    }

    //Give me a test that verifies that there is only one account with 0 balance
    /*
    @Test
    void testDos() {
        when(cuentaRepositorio.findBySaldo(0)).thenReturn(BaseDeDatos.cuentas.stream()
                .filter(e->e.getSaldo()==0)
                .findFirst()
                .get());
        Cuenta cuenta = cuentaRepositorio.findBySaldo(0);
        assertNotNull(cuenta);
    }

     */
}
