package dgtic.core.controller.hotel;

import dgtic.core.converter.MayusculasConverter;
import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.model.entity.HotelEntity;
import dgtic.core.service.cliente.HotelService;
import dgtic.core.util.RenderPagina;
import dgtic.core.validation.HotelValidacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("hotel")
public class HotelController {
    @Autowired
    private HotelValidacion hotelValidacion;

    @Autowired
    private HotelService hotelService;
    @GetMapping("/alta-hotel")
    public String paginaAltaHotel(Model model){
        HotelEntity hotelEntity = new HotelEntity();
        model.addAttribute("operacion", "altaHotel");
        model.addAttribute("hotelEntity",hotelEntity );
        return "hotel/alta-hotel";
    }

    @PostMapping("entrada-uno")
    public String almacenarHotel(@Valid HotelEntity hotelEntity, BindingResult result, Model model, RedirectAttributes flash ){
        if (result.hasErrors()){
            model.addAttribute("operacion", "Error en los datos");
            return "hotel/alta-hotel";
        }
        try {
            hotelService.guardar(hotelEntity);
            flash.addFlashAttribute("success", "Hotel guardado con éxito");
            return "redirect:/hotel/lista-hotel";
        }catch (Exception e){
            ObjectError er = new ObjectError("Error en los datos","Hubo un error en los datos");
            model.addAttribute("warning","Hubo un error en los datos");
            result.addError(er);
            return "hotel/alta-hotel";
        }
    }

    @GetMapping("/lista-hotel")
    public String paginaListaHotel(@RequestParam(name="page", defaultValue = "0") int page, Model model){
        Pageable pagReq = PageRequest.of(page, 6);
        Page<HotelEntity> hoteles = hotelService.findAll(pagReq);
        RenderPagina<HotelEntity> pageRender = new RenderPagina<>("lista-hotel", hoteles);
        model.addAttribute("hoteles", hoteles);
        model.addAttribute("page", pageRender);
        model.addAttribute("operacion", "lista Hotel");
        return "hotel/lista-hotel";
    }

    @InitBinder("hotelEntity")
    public void evaluar(WebDataBinder binder){
        binder.registerCustomEditor(String.class, "nombre", new MayusculasConverter());
    }

    @GetMapping("borrar-hotel/{id}")
    public String borrarHotel(@PathVariable("id") Integer id,Model model,
                                RedirectAttributes flash){
        hotelService.borrar(id);
        flash.addFlashAttribute("success","Hotel se borro bien");
        return "redirect:/hotel/lista-hotel";
    }

    @GetMapping("modificar-hotel/{id}")
    public String modificarCliente(@PathVariable("id") Integer id,Model model){
        HotelEntity hotel= hotelService.buscarHotelId(id);
        model.addAttribute("hotelEntity",hotel);
        return "hotel/alta-hotel";
    }
}
