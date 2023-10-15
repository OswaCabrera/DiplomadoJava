package dgtic.core.inicio;


import dgtic.core.modelo.Escena;
import dgtic.core.modelo.TipoEnemigo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"bean-configuration.xml", "bean-services.xml"});

        Escena escena = (Escena) context.getBean("escena");
        escena.getEnemigos().getEnemigo(TipoEnemigo.CATACUMBAS).dibujar();
        escena.getEnemigos().getEnemigo(TipoEnemigo.ESQUELETO).dibujar();
        escena.getEnemigos().getEnemigo(TipoEnemigo.CATACUMBAS).dibujar();
        System.out.println(escena.toString());

        escena.getVida().setNumeroVida(escena.getVida().getNumeroVida() - 1);

        Escena escena2 = (Escena) context.getBean("escena2");
        escena2.getEnemigos().getEnemigo(TipoEnemigo.MEDUSAS).dibujar();
        escena2.getEnemigos().getEnemigo(TipoEnemigo.MEDUSAS).dibujar();
        System.out.println(escena2.toString());


        ((ClassPathXmlApplicationContext) context).close();
    }
}
