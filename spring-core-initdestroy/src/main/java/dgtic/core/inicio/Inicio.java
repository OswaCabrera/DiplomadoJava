package dgtic.core.inicio;


import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.Persona;
import dgtic.core.modelo.TipoCarro;
import dgtic.core.servicio.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml", "bean-services.xml"});

        Empleado empleado = context.getBean("empleado", Empleado.class);
        System.out.println("---------------");
        Servicio servicio = context.getBean("servicio", Servicio.class);

        //empleado.limpiar();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
