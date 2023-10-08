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
        for (Actividades obj : emp.getActividad()) {
            obj.realiza();
        }
        System.out.println("--------------------------------------------------");
        Empleado empDos = (Empleado)context.getBean("empleadoDos");
        System.out.println(empDos.toString());
        for (Actividades obj : empDos.getActividad()) {
            obj.realiza();
        }

        System.out.println("--------------------------------------------------");
        EmpleadoM empTres = (EmpleadoM)context.getBean("empleadoTres");
        System.out.println(empTres.toString());
        for (String llave: empTres.getActividad().keySet()) {
            System.out.println("Llave: " + llave);
            empTres.getActividad().get(llave).realiza();
        }

        System.out.println("--------------------------------------------------");
        EmpleadoP empCuatro = (EmpleadoP)context.getBean("empleadoCuatro");
        System.out.println(empTres.toString());

        for(Iterator<Object> iter = empCuatro.getActividad().keySet().iterator();
            iter.hasNext();){
            String llave = (String)iter.next();
            System.out.println("Llave: " + llave);
            System.out.println(emp);
            System.out.println(empCuatro.getActividad().get(llave));
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
