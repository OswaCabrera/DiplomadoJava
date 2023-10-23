package mx.unam.dgtic.demopersonacrud;

import mx.unam.dgtic.demopersonacrud.modelo.Persona;
import mx.unam.dgtic.demopersonacrud.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemopersonacrudApplication implements CommandLineRunner {

	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemopersonacrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Demo Sprin Data CrudRepository con tabla persona");
		personaRepository.findAll().forEach(System.out::println);
		Persona persona = new Persona(0, "Isaac Asimov", 66);
		Persona resultado = personaRepository.save(persona);
		System.out.println("EL nuevo es : " + resultado);
	}
}
