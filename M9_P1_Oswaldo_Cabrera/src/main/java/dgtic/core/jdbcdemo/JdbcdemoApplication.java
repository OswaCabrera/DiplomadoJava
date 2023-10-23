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
	}
}
