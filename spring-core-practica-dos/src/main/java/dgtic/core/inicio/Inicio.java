package dgtic.core.inicio;


import dgtic.core.modelo.Actividades;
import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.EmpleadoM;
import dgtic.core.modelo.EmpleadoP;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml"});

        Empleado emp = (Empleado)context.getBean("empleado");
        System.out.println(emp.toString());
        emp.getActividad().realiza();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
