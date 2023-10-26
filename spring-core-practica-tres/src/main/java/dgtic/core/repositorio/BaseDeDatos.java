package dgtic.core.repositorio;
import java.util.ArrayList;
import java.util.List;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;

public class BaseDeDatos {
	public static List<Autor> autores =new ArrayList<>();
	public static List<Libro> libros =new ArrayList<>();
	static {
		Libro libro=new Libro("10", "Cálculo");
		libros.add(libro);
		Libro libro2 = new Libro("12","Probabilidad");
		libros.add(libro2);
		Autor autor = new Autor("Julio Cortez", "hola123@gmail.com");
		autor.addLibro(libro);
		autor.addLibro(libro2);
		autores.add(autor);
		Libro libro3=new Libro("11", "Física");
		libros.add(libro3);
		Libro libro4 = new Libro("13","Historia");
		libros.add(libro4);
		Autor autor2 = new Autor("Oswaldo", "hola@hmail.com");
		autor2.addLibro(libro3);
		autor2.addLibro(libro4);
		autores.add(autor2);
		Libro libro5=new Libro("14", "Química");
		libros.add(libro5);
		Libro libro6 = new Libro("15","Biología");
		libros.add(libro6);
		Autor autor3 = new Autor("Juan", "ha12@gmail.com");
		autor3.addLibro(libro5);
		autores.add(autor3);
	}
}
