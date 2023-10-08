package dgtic.core.inicio;


import dgtic.core.modelo.Persona;
import dgtic.core.modelo.TipoCarro;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml", "bean-services.xml"});

        Persona persona = (Persona) context.getBean("persona");
        persona.getCoche().getModeloCoche(TipoCarro.DEPORTIVO).crear();
        System.out.println(persona.toString());

        System.out.println("--------------------------------------------------");
        Persona personaDos = (Persona) context.getBean("persona");
        personaDos.setNombre("Rambo");
        personaDos.getCoche().getModeloCoche(TipoCarro.FAMILIAR).crear();
        System.out.println(personaDos.toString());
        System.out.println("_--------------------------------------------------");
        System.out.println(persona.getCoche());
        System.out.println(personaDos.getCoche());

        System.out.println(persona);
        System.out.println(personaDos);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
