package dgtic.core.jdbcdemo;

import dgtic.core.jdbcdemo.modelo.Persona;
import dgtic.core.jdbcdemo.modelo.Producto;
import dgtic.core.jdbcdemo.persistencia.PersonaDao;
import dgtic.core.jdbcdemo.persistencia.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JdbcdemoApplication implements CommandLineRunner {

	@Autowired
	private PersonaDao personaDao;

	@Autowired
	private ProductoDAO productoDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando aplicación");
		//Insertar un nuevo producto
		System.out.println("Insertando un nuevo producto");
		Producto producto = new Producto();
		producto.setDescripcion("Chicles");
		producto.setPrecio(100);
		producto.setStock(10);
		productoDao.insertar(producto);
		//Consultar todos los productos
		System.out.println("Consultando todos los productos");
		ArrayList<Producto> productos = (ArrayList<Producto>) productoDao.findAll();
		for (Producto p : productos) {
			System.out.println(p);
		}
		//Actualizar un producto
		System.out.println("Actualizando el precio del producto producto");
		producto.setPrecio(271);
		productoDao.cambiar(producto);
		//consultar el producto
		System.out.println("Consultando el producto");
		System.out.println(productoDao.consultaNombre("Chicles"));
		//Borrar el primer producto
		System.out.println("Borrando el primer producto");
		productoDao.borrar(productos.get(0));
		//Consultar todos los productos
		System.out.println("Consultando todos los productos");
		productos = (ArrayList<Producto>) productoDao.findAll();
		for (Producto p : productos) {
			System.out.println(p);
		}
	}
}
