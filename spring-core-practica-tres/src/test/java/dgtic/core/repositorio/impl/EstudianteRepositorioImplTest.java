package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Estudiante;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.EstudianteRepositorio;
import dgtic.core.servicio.EstudianteServicio;
import dgtic.core.servicio.EstudianteServicioImpl;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteRepositorioImplTest {
    /*

    @Test
    void findAll() {
        EstudianteRepositorio estudianteRepositorio=new EstudianteRepositorioImpl();
        EstudianteServicio estudianteServicio=new EstudianteServicioImpl(estudianteRepositorio,null);
        Estudiante est=estudianteServicio.findById("123");
        //cambiar la matricula
        assertNotNull(est);
        //cambiar Rosa-->Rosas
        assertEquals("Rosa",est.getNombre(),"No iguales");

    }
    //no mock de metodos privados,estaticos,final
    @Test
    void findAllMockito() {
        //Dado que Prepara el contexto
        EstudianteRepositorio estudianteRepositorio= Mockito.mock(EstudianteRepositorio.class);
        EstudianteServicio estudianteServicio=new EstudianteServicioImpl(estudianteRepositorio,null);
        //Cuando se invoque un metodo
        Mockito.when(estudianteRepositorio.findAll())
                .thenReturn(BaseDeDatos.estudiantes);
        //entonces ya validamos
        Estudiante est=estudianteServicio.findById("123");
        //cambiar la matricula
        assertNotNull(est);
        //cambiar Rosa-->Rosas
        assertEquals("Rosa",est.getNombre(),"No iguales");

    }
    //Otro Contexto
    @Test
    void findAllMockitoNull() {
        //Dado que Prepara el contexto
        EstudianteRepositorio estudianteRepositorio= Mockito.mock(EstudianteRepositorio.class);
        EstudianteServicio estudianteServicio=new EstudianteServicioImpl(estudianteRepositorio,null);
        //Cuando se invoque un metodo
        Mockito.when(estudianteRepositorio.findAll())
                .thenReturn(Collections.emptyList());
        //entonces ya validamos
        Estudiante est=estudianteServicio.findById("123");
        //cambiar la matricula
        assertNotNull(est);
        //cambiar Rosa-->Rosas
        assertEquals("Rosa",est.getNombre(),"No iguales");

    }

     */
}