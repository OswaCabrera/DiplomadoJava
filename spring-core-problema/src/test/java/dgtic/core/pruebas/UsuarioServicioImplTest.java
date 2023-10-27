package dgtic.core.pruebas;

import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.UsuarioRepositorio;
import dgtic.core.servicio.UsuarioServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {UsuarioServicioImplTest.class})
@ComponentScan(basePackages = "dgtic.core")
public class UsuarioServicioImplTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @InjectMocks
    private UsuarioServicioImpl usuarioServicio;

    @Test
    void testUno() {
        when(usuarioRepositorio.findAll()).thenReturn(BaseDeDatos.usuarios);
        assertEquals(2, usuarioRepositorio.findAll().size());
    }

    @Test
    void TestDos() {
    	when(usuarioRepositorio.findByNombre("Juan")).thenReturn(BaseDeDatos.usuarios.stream()
    			.filter(e->e.getNombre().equals("Juan"))
    			.findFirst()
    			.get());
    	assertEquals("Juan", usuarioRepositorio.findByNombre("Juan").getNombre());
    }

    @Test
    void TestTres() {
    	when(usuarioRepositorio.findByNombreAndPassword("Juan", "123")).thenReturn(BaseDeDatos.usuarios.stream()
    			.filter(e->e.getNombre().equals("Juan") && e.getPassword().equals("123"))
    			.findFirst()
    			.get());
        	assertEquals("Juan", usuarioRepositorio.findByNombreAndPassword("Juan", "123").getNombre());
    }

    @Test
    void TestCuatro() {
    	when(usuarioRepositorio.crear()).thenReturn(BaseDeDatos.usuarios.stream()
    			.filter(e->e.getNombre().equals("Juan") && e.getPassword().equals("123"))
    			.findFirst()
    			.get());
        	assertEquals("Nueva", usuarioRepositorio.crear().getCuenta().getEstatusCuenta().getNombre());
    }

    @Test
    void TestCinco() {
        when(usuarioRepositorio.obtenerCorreoPorTelefono("1234567890")).thenReturn(BaseDeDatos.usuarios.stream()
                .filter(e->e.getTelefono().equals("1234567890"))
                .findFirst()
                .get().getEmail());
        assertEquals("hola121@gmail.com", usuarioRepositorio.obtenerCorreoPorTelefono("1234567890"));

    }
}
