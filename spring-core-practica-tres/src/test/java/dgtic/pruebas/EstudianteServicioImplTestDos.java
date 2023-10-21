package dgtic.pruebas;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import dgtic.core.excepciones.CreditosMenores;
import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.EstudianteRepositorio;
import dgtic.core.repositorio.intf.MateriaRepositorio;
import dgtic.core.servicio.EstudianteServicio;
import dgtic.core.servicio.EstudianteServicioImpl;
@SpringBootTest(classes = {EstudianteServicioImplTestDos.class})
@ComponentScan(basePackages = "dgtic.core")
class EstudianteServicioImplTestDos {
	@Mock
	private EstudianteRepositorio estudianteRespositorio;
	@Mock
	private MateriaRepositorio materiaRepositorio;
	@InjectMocks
	private EstudianteServicioImpl estudianteServicio;
	
	@Test
	void testUno() {
		
		when(estudianteRespositorio.findAll()).thenReturn(BaseDeDatos.estudiantes);
		when(estudianteRespositorio.findById(anyString())).thenReturn(BaseDeDatos.estudiantes.stream()
				.filter(e->e.getMatricula().equals("123"))
				.findFirst()
				.get());
		assertEquals(4, estudianteServicio.findAll().size());
		assertEquals(3,estudianteRespositorio.findById("123").getMaterias().size());
		assertEquals("Rosa", estudianteServicio.findById("123").getNombre());
		assertEquals("123;1;Cálculo;9;2;Programación;10;3;Lógica;10;Rosa;20", 
				estudianteServicio.archivoCSV("123"));
		assertEquals(29, estudianteServicio.creditos("123"));
		
	}
	
	/**
	 * 
	 */
	@Test
	void testDos() {		
		when(estudianteRespositorio.findAll()).thenReturn(BaseDeDatos.estudiantes);
		when(estudianteRespositorio.findById("123")).thenReturn(BaseDeDatos.estudiantes.stream()
				.filter(e->e.getMatricula().equals("123"))
				.findFirst()
				.get());		
		//assertEquals(3,estudianteRespositorio.findById("123").getMaterias().size());
		//verify(estudianteRespositorio).findById(anyString());
		
		
		//assertEquals(29, estudianteServicio.creditos("123"));
		//verify(estudianteRespositorio).findAll();
		
		/*assertEquals(4, estudianteServicio.findAll().size());
		assertEquals("123;1;Cálculo;9;2;Programación;10;3;Lógica;10;Rosa;20", 
				estudianteServicio.archivoCSV("123"));
		verify(estudianteRespositorio,times(2)).findAll();*/
		
	}
	
	@Test
	void testTres() {		
		when(estudianteRespositorio.findAll()).thenReturn(BaseDeDatos.estudiantes);
		when(estudianteRespositorio.findById("123")).thenReturn(BaseDeDatos.estudiantes.stream()
				.filter(e->e.getMatricula().equals("123"))
				.findFirst()
				.get());
		
		
		//correcto se lanza la excepcion
		assertThrows(CreditosMenores.class, ()->{
			estudianteRespositorio.findById("123").getMaterias().get(0)
			.setCreditos(-11);
		});
		//correcto, nunca se ejecuta
		//verify(estudianteRespositorio,never()).findAll();
		
		//correcto, nunca se ejecuta una sola vez.
		//verify(materiaRepositorio,times(0)).save(any(Materia.class));
		
		//simulando insertar
		//materiaRepositorio.save(any(Materia.class));
		//comprobar cuantas veces se llama
		//verify(materiaRepositorio,times(1)).save(any());
		
	}
	
	@Test
	void testCuatro() {		
		when(estudianteRespositorio.findById("124")).thenReturn(BaseDeDatos.estudiantes.stream()
				.filter(e->e.getMatricula().equals("124"))
				.findFirst()
				.get());
		Estudiante estudianteUno=estudianteServicio.findById("124");
		Estudiante estudianteDos=estudianteServicio.findById("124");
		
		//verificar que sea la misma instancia (dos maneras distintas)
		//assertSame(estudianteUno,estudianteDos);
		//assertTrue(estudianteUno==estudianteDos);
		
		//assertEquals(estudianteUno.getNombre(), estudianteDos.getNombre());
		//verify(estudianteRespositorio,times(3)).findById("124");
		
		
		
		
	}
	

}
