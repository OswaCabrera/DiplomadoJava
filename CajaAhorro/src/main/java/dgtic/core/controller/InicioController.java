package dgtic.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InicioController {

    @Value("${spring.application.name}")
    String nombreApp;

    @GetMapping("/")
    public String inicioPagina(Model model)  {
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("nombreAplicacion",nombreApp);
        model.addAttribute("fecha",formateadorFecha.format(new Date()));
        return "inicio";
    }
    @GetMapping("/inicio")
    public String paginaPrincipal(Model model){
        model.addAttribute("contenido","lo que quieras");
        return "principal";
    }

}
