package dgtic.core.servicio;

import dgtic.core.modelo.Estudiante;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource(locations = {"classpath:/bean-configuration.xml"})
@ComponentScan(basePackages = "dgtic.core")
public class ConfiguracionServicio {
    @Bean(name = "estudiante")
    @Scope("prototype")
    public Estudiante servicioEstudiante() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Juan");
        estudiante.setEdad(20);
        return estudiante;
    }
}
