package dgtic.core.inicio;


import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import dgtic.core.servicio.ConfiguracionServicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(
          //      new String[]{"bean-configuration.xml", "bean-services.xml"});

        //ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext("dgtic.core");

        ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext(ConfiguracionServicio.class);

        Estudiante estudiante = contexto.getBean("estudiante", Estudiante.class);
        System.out.println(estudiante.toString());

        Estudiante estudiante2 = contexto.getBean("estudianteDos", Estudiante.class);
        System.out.println(estudiante2.toString());
        System.out.println("-----------");
        Materia materia = contexto.getBean("materia", Materia.class);
        System.out.println(materia.toString());
        contexto.close();
    }
}
