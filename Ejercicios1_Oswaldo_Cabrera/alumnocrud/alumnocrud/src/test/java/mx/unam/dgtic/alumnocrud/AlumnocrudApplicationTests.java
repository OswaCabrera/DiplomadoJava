package mx.unam.dgtic.alumnocrud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class AlumnocrudApplicationTests {

	@Test
	@Sql({"/schema.sql","/data.sql"})
	void contextLoads(){
		System.out.println("Creando esquema y poblando tabla");
	}

}
