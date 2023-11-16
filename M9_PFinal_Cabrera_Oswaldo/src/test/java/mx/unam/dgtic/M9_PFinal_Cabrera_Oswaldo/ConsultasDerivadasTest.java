package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository.CuentaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsultasDerivadasTest {

    @Autowired
    private CuentaRepository cuentaRepository;


    @Test
    void saldoMayorTest(){
        System.out.println(InfoTester.NOMBRE);
        cuentaRepository.findBySaldoGreaterThan(1000).forEach(System.out::println);
    }

    @Test
    void fechaDespuesTest(){
        System.out.println(InfoTester.NOMBRE);
        cuentaRepository.findByFechaAperturaAfter(java.sql.Date.valueOf("2023-11-20")).forEach(System.out::println);
    }

    @Test
    void findBySaldoGreaterThanAndFechaAperturaAfterTest(){
        System.out.println(InfoTester.NOMBRE);
        cuentaRepository.findBySaldoGreaterThanAndFechaAperturaAfter(200, java.sql.Date.valueOf("2023-11-15")).forEach(System.out::println);
    }

    @Test
    void findByEstatusAndSaldoGreaterThanTest(){
        System.out.println(InfoTester.NOMBRE);
        cuentaRepository.findByEstatusAndSaldoGreaterThan(1, 100).forEach(System.out::println);
    }

}
