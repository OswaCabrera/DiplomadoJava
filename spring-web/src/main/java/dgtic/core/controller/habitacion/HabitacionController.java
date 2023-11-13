package dgtic.core.controller.habitacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("habitacion")
public class HabitacionController {
    @RequestMapping("/alta-habitacion")
    public String paginaAltaHabitacion(){
        return "habitacion/alta-habitacion";
    }

    @RequestMapping("/lista-habitacion")
    public String paginaListaHabitacion(){
        return "habitacion/lista-habitacion";
    }
}
