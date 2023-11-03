package dgtic.core.M9_P2_Oswaldo_Cabrera;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class M9P2OswaldoCabreraApplicationTests {

	@Test
	@Sql({"/autos_propiet_schema.sql","/autos_data.sql"})
	void contextLoads() {
	}

}
