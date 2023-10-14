package dgtic.core;


import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import dgtic.core.repositorio.intf.BaseDeDatosDao;
import dgtic.core.servicio.ConfiguracionServicio;
import dgtic.core.servicio.ServicioDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(
          //      new String[]{"bean-configuration.xml", "bean-services.xml"});

        //ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext("dgtic.core");

        ApplicationContext context = new AnnotationConfigApplicationContext("dgtic.core");

        BaseDeDatosDao serv = context.getBean("baseDeDatosDao", BaseDeDatosDao.class);
        System.out.println(serv.getEstudiantes("ico"));
        System.out.println(serv.getEstudiante("ime", "126"));

        System.out.println("------------");
        ServicioDAO csv = context.getBean("servicioDAO", ServicioDAO.class);
        System.out.println(csv.archivoCSV("ico"));

        ((ConfigurableApplicationContext) context).close();
    }
}
