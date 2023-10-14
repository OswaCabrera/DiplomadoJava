package dgtic.core.inicio;


import dgtic.core.modelo.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml"});

        Usuario usuario = (Usuario)context.getBean("usuario");
        System.out.println(usuario.toString());
        usuario.setNombre("Oswaldo");
        usuario.setApellidoPaterno("Cabrera");
        usuario.setApellidoMaterno("Pérez");
        usuario.setEmail("oswaldo@gmail.com");
        usuario.setPassword("123456");
        usuario.setTelefono("1234567890");
        usuario.setDireccion("Calle 1");

        System.out.println(usuario.toString());

        Transaccion transaccion = (Transaccion)context.getBean("transaccion");
        transaccion.setMonto(1000);
        transaccion.setCuenta(usuario.getCuenta());

        System.out.println(usuario.toString());

        System.out.println(transaccion.toString());






        ((ClassPathXmlApplicationContext) context).close();
    }
}
