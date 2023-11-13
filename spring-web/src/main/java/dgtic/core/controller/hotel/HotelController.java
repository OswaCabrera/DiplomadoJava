package dgtic.core.controller.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hotel")
public class HotelController {
    @RequestMapping("/alta-hotel")
    public String paginaAltaHotel(){
        return "hotel/alta-hotel";
    }

    @RequestMapping("/lista-hotel")
    public String paginaListaHotel(){
        return "hotel/lista-hotel";
    }
}
