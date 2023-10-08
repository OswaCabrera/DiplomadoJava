package dgtic.core.inicio;


import dgtic.core.servicio.EmpleadoServicio;
import dgtic.core.servicio.PredeterminadoServicio;
import dgtic.core.servicio.ReporteEmpleadoServicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml", "bean-services.xml"});

        EmpleadoServicio servUno = (EmpleadoServicio) context.getBean("empleadoServicio");
        servUno.servicioEmpleado();

        ReporteEmpleadoServicio servDos = (ReporteEmpleadoServicio) context.getBean("empleadoServicioReporte");
        servDos.reporteDiario();

        PredeterminadoServicio servTres = (PredeterminadoServicio) context.getBean("servicioLocal");
        servTres.getEmpleadoServicio().servicioEmpleado();
        servTres.getReporteEmpleadoServicio().reporteDiario();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
