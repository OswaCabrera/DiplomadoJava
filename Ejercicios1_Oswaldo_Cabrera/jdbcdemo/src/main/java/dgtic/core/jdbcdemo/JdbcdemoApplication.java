package dgtic.core.jdbcdemo;

import dgtic.core.jdbcdemo.modelo.Persona;
import dgtic.core.jdbcdemo.persistencia.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JdbcdemoApplication implements CommandLineRunner {

	@Autowired
	private PersonaDao personaDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola");
		ArrayList<Persona> personas = (ArrayList<Persona>) personaDao.consulta();
		for (Persona persona: personas){
			System.out.println(persona);
		}
		System.out.println("La persona con id 1 es: " + personaDao.consultaId(1));
		System.out.println("Insertando persona");
		Persona persona = new Persona();
		persona.setNombre("Juan");
		persona.setEdad(20);
		personaDao.insertar(persona);
		ArrayList<Persona> personas2 = (ArrayList<Persona>) personaDao.consulta();
		for (Persona persona1: personas2){
			System.out.println(persona1);
		}
		System.out.println("Cambiando persona");
		persona.setNombre("Juanito");
		personaDao.cambiar(persona);
		ArrayList<Persona> personas3 = (ArrayList<Persona>) personaDao.consulta();
		for (Persona persona1: personas3){
			System.out.println(persona1);
		}
		System.out.println("Borrando persona");
		personaDao.borrar(persona);
		ArrayList<Persona> personas4 = (ArrayList<Persona>) personaDao.consulta();
		for (Persona persona1: personas4){
			System.out.println(persona1);
		}
		System.out.println("Numero de personas de 34 años y menos");

		System.out.println(personaDao.callSpedad(34));
	}
}
