package dgtic.core.controller.reservacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reservacion")
public class ReservacionController {
    @RequestMapping("/alta-reservacion")
    public String paginaAltaReservacion(){
        return "reservacion/alta-reservacion";
    }

    @RequestMapping("/lista-reservacion")
    public String paginaListaReservacion(){
        return "reservacion/lista-reservacion";
    }
}
