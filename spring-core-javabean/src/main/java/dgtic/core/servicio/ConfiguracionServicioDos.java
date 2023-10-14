package dgtic.core.servicio;

import dgtic.core.modelo.Estudiante;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource(locations = {"classpath:/bean-configuration.xml"})
//@ComponentScan(basePackages = "dgtic.core")
public class ConfiguracionServicioDos {
    @Bean(name = "estudianteDos")
    @Scope("prototype")
    public Estudiante servicioEstudiante() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Kenia Os");
        estudiante.setEdad(24);
        return estudiante;
    }
}
