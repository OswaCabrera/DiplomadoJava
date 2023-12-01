package dgtic.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @Value("${spring.application.name}")
    String nombreApp;

    @GetMapping("/")
    public String inicioPagina(Model model)  {
        model.addAttribute("nombreAplicacion",nombreApp);
        return "inicio";
    }

    @GetMapping("/inicio")
    public String paginaPrincipal(Model model){
        model.addAttribute("contenido","Bienvenido a la aplicación de la Caja de Ahorro");
        return "principal";
    }
}
