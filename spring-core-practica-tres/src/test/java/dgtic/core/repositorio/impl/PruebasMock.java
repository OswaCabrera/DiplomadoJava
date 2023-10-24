package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.LibroRepositorio;
import dgtic.core.servicio.LibroServicio;
import dgtic.core.servicio.LibroServicioImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasMock {

    @Test
    void findAllLibro(){
        LibroRepositorio libroRepositorio = Mockito.mock(LibroRepositorio.class);
        LibroServicio libroServicio = new LibroServicioImpl(null, libroRepositorio);
        Mockito.when(libroRepositorio.findAll()).thenReturn(BaseDeDatos.libros);
        Libro libro = libroServicio.findById("10");
        assertNull(libro);
        //assertEquals("Geografia", libro.getNombre(), "No iguales");
    }
}
