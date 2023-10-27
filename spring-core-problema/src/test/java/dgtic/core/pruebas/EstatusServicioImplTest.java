package dgtic.core.pruebas;

import dgtic.core.modelo.Usuario;
import dgtic.core.repositorio.intf.EstatusCuentaRepositorio;
import dgtic.core.repositorio.intf.UsuarioRepositorio;
import dgtic.core.servicio.EstatusCuentaServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import dgtic.core.repositorio.BaseDeDatos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {EstatusServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class EstatusServicioImplTest {

    @Mock
    private EstatusCuentaRepositorio estatusRepositorio;

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @InjectMocks
    private EstatusCuentaServicioImpl estatusServicio;

    @Test
    void testUno() {
        when(estatusRepositorio.findAll()).thenReturn(BaseDeDatos.estatusCuenta);
        assertEquals(3, estatusRepositorio.findAll().size());
        when(estatusRepositorio.findAll()).thenReturn(BaseDeDatos.estatusCuenta);
        assertEquals(3, estatusServicio.findAll().size());
    }


    @Test
    void testDos(){
        when(estatusRepositorio.findAll()).thenReturn(BaseDeDatos.estatusCuenta);
        // Los estados de una cuenta son singleton así que deberían de ser el mismo objecto
        assertSame(estatusRepositorio.findAll().get(1), estatusServicio.findAll().get(0));
    }

    @Test
    void testTres(){
        when(usuarioRepositorio.findByNombre("Oswaldo")).thenReturn(BaseDeDatos.usuarios.stream()
                .filter(e->e.getNombre().equals("Oswaldo"))
                .findFirst()
                .get());
        Usuario usuario = usuarioRepositorio.findByNombre("Oswaldo");
        when(estatusRepositorio.findByNombre("Nueva")).thenReturn(BaseDeDatos.estatusCuenta.stream()
                .filter(e->e.getNombre().equals("Nueva"))
                .findFirst()
                .get());
        assertEquals("Nueva", usuario.getCuenta().getEstatusCuenta().getNombre());
    }


    @Test
    void testCuatro() {
        when(estatusRepositorio.findByNombre("Nueva")).thenReturn(BaseDeDatos.estatusCuenta.stream()
                .filter(e->e.getNombre().equals("Nueva"))
                .findFirst()
                .get());
        assertEquals("Nueva", estatusRepositorio.findByNombre("Nueva").getNombre());
    }

    @Test
    void testCinco() {
        when(estatusRepositorio.findByNombre("Deshabilitada")).thenReturn(BaseDeDatos.estatusCuenta.stream()
                .filter(e->e.getNombre().equals("Deshabilitada"))
                .findFirst()
                .get());
        assertEquals("Deshabilitada", estatusRepositorio.findByNombre("Deshabilitada").getNombre());
    }


}
