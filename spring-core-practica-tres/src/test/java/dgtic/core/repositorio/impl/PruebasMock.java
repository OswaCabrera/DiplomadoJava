package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.AutorRepositorio;
import dgtic.core.repositorio.intf.LibroRepositorio;
import dgtic.core.servicio.AutorServicio;
import dgtic.core.servicio.AutorServicioImpl;
import dgtic.core.servicio.LibroServicio;
import dgtic.core.servicio.LibroServicioImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasMock {

    @Test
    void findAllLibro(){
        LibroRepositorio libroRepositorio = Mockito.mock(LibroRepositorio.class);
        LibroServicio libroServicio = new LibroServicioImpl(libroRepositorio);
        Mockito.when(libroRepositorio.findAll()).thenReturn(BaseDeDatos.libros);
        Libro libro = libroServicio.findById("10");
        assertNotNull(libro);
        assertEquals("Cálculo", libro.getNombre(), "Iguales");
    }

    @Test
    void findAllAutor(){
        AutorRepositorio autorRepositorio = Mockito.mock(AutorRepositorio.class);
        AutorServicio autorServicio = new AutorServicioImpl(autorRepositorio);
        Mockito.when(autorRepositorio.findAll()).thenReturn(BaseDeDatos.autores);
        Autor autor = autorServicio.findById("hola123@gmail.com");
        assertNotNull(autor);
        assertEquals("Julio Cortez", autor.getNombre(), "Iguales");
    }

}
