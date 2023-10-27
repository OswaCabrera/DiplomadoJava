package dgtic.core.repositorio;

import dgtic.core.modelo.Cuenta;
import dgtic.core.modelo.EstatusCuenta;
import dgtic.core.modelo.Transaccion;
import dgtic.core.modelo.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Transaccion> transacciones = new ArrayList<>();
    public static List<EstatusCuenta> estatusCuenta = new ArrayList<>();
    public static List<Cuenta> cuentas = new ArrayList<>();

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml"});

        Usuario usuario = (Usuario)context.getBean("usuario");
        usuario.setNombre("Oswaldo");
        usuario.setApellidoPaterno("Cabrera");
        usuario.setApellidoMaterno("Pérez");
        usuario.setEmail("oswaldo@gmail.com");
        usuario.setPassword("123456");
        usuario.setTelefono("12345678910");
        usuario.setDireccion("Calle 1");
        usuario.getCuenta().setSaldo(500);

        usuarios.add(usuario);
        cuentas.add(usuario.getCuenta());
        estatusCuenta.add(usuario.getCuenta().getEstatusCuenta());

        Usuario usuario2 = (Usuario)context.getBean("usuario");
        usuario2.setNombre("Juan");
        usuario2.setApellidoPaterno("Pérez");
        usuario2.setApellidoMaterno("Gómez");
        usuario2.setEmail("hola121@gmail.com");
        usuario2.setPassword("123");
        usuario2.setTelefono("1234567890");
        usuario2.setDireccion("Calle 1");

        usuarios.add(usuario2);
        cuentas.add(usuario2.getCuenta());
        estatusCuenta.add(usuario2.getCuenta().getEstatusCuenta());

        Transaccion transaccion = (Transaccion)context.getBean("transaccion");
        transaccion.setId("1");
        transaccion.setMonto(1000);
        transaccion.setCuenta(usuario.getCuenta());
        transacciones.add(transaccion);

        Transaccion transaccion2 = (Transaccion)context.getBean("transaccion");
        transaccion2.setId("2");
        transaccion2.setMonto(500);
        transaccion2.setCuenta(usuario2.getCuenta());
        transacciones.add(transaccion2);

        EstatusCuenta estatusCuenta2 = (EstatusCuenta)context.getBean("cuentaDeshabilitada");
        estatusCuenta.add(estatusCuenta2);


        ((ClassPathXmlApplicationContext) context).close();
    }
}
