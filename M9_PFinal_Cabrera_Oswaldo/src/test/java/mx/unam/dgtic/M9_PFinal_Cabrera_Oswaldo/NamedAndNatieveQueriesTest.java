package mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo;

import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Cuenta;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Usuario;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository.CuentaRepository;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository.TransaccionRepository;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Usuario;
import mx.unam.dgtic.M9_PFinal_Cabrera_Oswaldo.model.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class NamedAndNatieveQueriesTest {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;


    //insert 5 registers into the table transaccion using CRUD repositorio (save)
    @Test
    void save5Transacciones(){
        System.out.println(InfoTester.NOMBRE);
        Transaccion transaccion1 = new Transaccion();
        transaccion1.setMonto(1000);
        transaccion1.setFecha(new Date());
        transaccion1.setCuenta_id(cuentaRepository.findById(5));
        transaccionRepository.save(transaccion1);

        Transaccion transaccion2 = new Transaccion();
        transaccion2.setMonto(1000);
        transaccion2.setFecha(new Date());
        transaccion2.setCuenta_id(cuentaRepository.findById(5));
        transaccionRepository.save(transaccion2);

        Transaccion transaccion3 = new Transaccion();
        transaccion3.setMonto(1000);
        transaccion3.setFecha(new Date());
        transaccion3.setCuenta_id(cuentaRepository.findById(5));
        transaccionRepository.save(transaccion3);

        Transaccion transaccion4 = new Transaccion();
        transaccion4.setMonto(1000);
        transaccion4.setFecha(new Date());
        transaccion4.setCuenta_id(cuentaRepository.findById(5));
        transaccionRepository.save(transaccion4);

        Transaccion transaccion5 = new Transaccion();
        transaccion5.setMonto(1000);
        transaccion5.setFecha(new Date());
        transaccion5.setCuenta_id(cuentaRepository.findById(5));
        transaccionRepository.save(transaccion5);
    }

    @Test
    void update2fields2Registers(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Antes de actualizar");
        Usuario usuario = usuarioRepository.findById(6);
        System.out.println(usuario);
        usuario.setZip(56321);
        usuario.setEstado("Oaxaca");
        usuarioRepository.save(usuario);
        Usuario usuarioActualizado = usuarioRepository.findById(6);
        System.out.println("Despues de actualizar");
        System.out.println(usuarioActualizado);

        System.out.println("Segundo registro");
        System.out.println("Antes de actualizar");
        Usuario usuario2 = usuarioRepository.findById(7);
        System.out.println(usuario2);
        usuario2.setZip(86825);
        usuario2.setEstado("Guerreo");
        usuarioRepository.save(usuario2);
        System.out.println("Despues de actualizar");
        System.out.println(usuarioRepository.findById(7));
    }

    @Test
    void deleteUsuario(){
        System.out.println(InfoTester.NOMBRE);
        Usuario usuario = usuarioRepository.findByContrasenaAndEmail("password5", "user5@example.com");
        System.out.println(usuario);
        usuarioRepository.delete(usuario);
    }

    @Test
    void buscarCuentasConUsuarioTest(){
        System.out.println(InfoTester.NOMBRE);
        System.out.println("Cuentas con saldo mayor a 1000");
        cuentaRepository.buscarTodasCuentas().forEach(System.out::println);
    }

    @Test
    void buscarTransaccionesConCuentaTest(){
        System.out.println(InfoTester.NOMBRE);
        transaccionRepository.buscarTodasTransaccionesConCuenta().forEach(System.out::println);
    }

    @Test
    void buscarTodosUsuariosConCuentasTest(){
        System.out.println(InfoTester.NOMBRE);
        List<Object[]> resultados = usuarioRepository.buscarTodosUsuariosConCuentas();
        for (Object[] resultado : resultados) {
            if(resultado[0] instanceof Usuario ){
                System.out.println((Usuario)resultado[0]);
            }else{
            System.out.println((Cuenta)resultado[0]);}
        }
    }

    @Test
    void buscarCuentaYTransaccionTest(){
        System.out.println(InfoTester.NOMBRE);
        List<Cuenta> resultados = cuentaRepository.buscarCuentaYTransacciones(4);
        resultados.forEach(System.out::println);
    }

    @Test
    void buscarUsuarioyCuentaTest(){
        System.out.println(InfoTester.NOMBRE);
        Usuario resultado = usuarioRepository.buscarUsuarioyCuenta(4);
        System.out.println(resultado);
    }

}
