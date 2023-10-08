package dgtic.core.inicio;


import dgtic.core.modelo.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml"});

        Empleado emp = (Empleado)context.getBean("empleado");
        System.out.println(emp.toString());
        emp.getActividad().realiza();
        Empleado empDos = (Empleado)context.getBean("empleadoDos");
        empDos.getActividad().realiza();
        Empleado empTres = (Empleado)context.getBean("empleadoTres");
        empTres.getActividad().realiza();
        Empleado empCuatro = (Empleado)context.getBean("empleadoCuatro");
        empCuatro.getActividad().realiza();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
