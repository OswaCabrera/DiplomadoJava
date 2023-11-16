package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class M9PFinalCabreraOswaldoApplicationTests {

	@Test
	@Sql({"/base_caja_ahorro_script.sql", "/data_caja.sql"})
	void contextLoads() {
		System.out.println(InfoTester.NOMBRE);
		System.out.println("Creando esquema y poblando tabla");
	}

}
