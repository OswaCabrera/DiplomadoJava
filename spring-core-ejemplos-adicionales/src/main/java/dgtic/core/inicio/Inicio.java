package dgtic.core.inicio;


import dgtic.core.modelo.Producto;
import dgtic.core.servicio.ConfiguracionServicio;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(
          //      new String[]{"bean-configuration.xml", "bean-services.xml"});

        //ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext("dgtic.core");

        ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext(ConfiguracionServicio.class);

        Producto coca = contexto.getBean("chico", Producto.class);
        System.out.println(coca.toString());

        Producto pila = contexto.getBean("sonyPilas", Producto.class);
        System.out.println(pila.toString());

        Producto pila2 = contexto.getBean("sonyPilas", Producto.class);
        System.out.println(pila2.toString());

        contexto.close();
    }
}
