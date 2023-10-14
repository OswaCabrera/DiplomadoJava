package dgtic.core.servicio;

import dgtic.core.modelo.Pilas;
import dgtic.core.modelo.Refresco;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource(locations = {"classpath:/bean-configuration.xml"})
@ComponentScan(basePackages = "dgtic.core")
public class ConfiguracionServicio {
    @Bean
    @Scope("prototype")
    public Refresco chico(){
        Refresco refresco = new Refresco();
        refresco.setNombre("Coca Cola");
        refresco.setCapacidad(600);
        refresco.setPrecio(15);
        return refresco;
    }

    @Bean
    @Scope("prototype")
    public Pilas sonyPilas(){
        Pilas pilas = new Pilas();
        pilas.setNombre("Sony");
        pilas.setPrecio(50);
        pilas.setRecargables(true);
        return pilas;
    }

    @Bean(initMethod = "abrirArchivo", destroyMethod = "cerrarArchivo")
    public Registro registrar (){
        String direc = System.getProperty("java.io.tmpdir") + "/compras";
        System.out.println("El directorio es: " + direc);
        Registro registro = new Registro();
        registro.setNombreArchivo("compras_oct");
        registro.setDireccion(direc);
        return registro;
    }
}
