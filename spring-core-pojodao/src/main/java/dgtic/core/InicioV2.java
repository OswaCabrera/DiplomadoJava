package dgtic.core;


import dgtic.core.repositorio.intf.BaseDeDatosDao;
import dgtic.core.servicio.ServicioDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InicioV2 {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(
          //      new String[]{"bean-configuration.xml", "bean-services.xml"});

        //ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext("dgtic.core");

        ApplicationContext context = new AnnotationConfigApplicationContext("dgtic.core");

        ServicioDAO csv = context.getBean(ServicioDAO.class);
        BaseDeDatosDao serv = csv.getServicioDAO();
        System.out.println(serv.getEstudiantes("ico"));
        ((ConfigurableApplicationContext) context).close();
    }
}
