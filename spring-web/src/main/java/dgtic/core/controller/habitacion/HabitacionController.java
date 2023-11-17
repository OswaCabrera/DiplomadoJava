package dgtic.core.controller.habitacion;

import dgtic.core.converter.MayusculasConverter;
import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.model.entity.HabitacionEntity;
import dgtic.core.service.cliente.HabitacionService;
import dgtic.core.service.cliente.HotelService;
import dgtic.core.util.RenderPagina;
import dgtic.core.validation.HabitacionValidacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionValidacion habitacionValidacion;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/alta-habitacion")
    public String paginaAltaHabitacion(Model model){
        HabitacionEntity habitacionEntity = new HabitacionEntity();
        model.addAttribute("operacion", "altaHabitacion");
        model.addAttribute("habitacionEntity",habitacionEntity );
        return "habitacion/alta-habitacion";
    }

    @PostMapping("entrada-uno")
    public String almacenarHabitacion(@Valid HabitacionEntity habitacionEntity, BindingResult result, Model model, RedirectAttributes flash ){

        if(result.hasErrors()){
            model.addAttribute("operacion", "Error en los datos");
            return "habitacion/alta-habitacion";
        }
        try {
            habitacionEntity.setHotel(hotelService.buscarHotelId(1));
            habitacionService.guardar(habitacionEntity);
            flash.addFlashAttribute("success", "Habitacion guardadacon éxito");
            return "redirect:/habitacion/lista-habitacion";
        }catch (Exception e){
            ObjectError er = new ObjectError("Error en los datos","Hubo un error en los datos");
            model.addAttribute("warning","Hubo un error en los datos");
            result.addError(er);
            return "habitacion/alta-habitacion";
        }
    }



    @GetMapping("/lista-habitacion")
    public String paginaListaHabitacion(@RequestParam(name="page", defaultValue = "0") int page, Model model){
        Pageable pagReq = PageRequest.of(page, 6);
        Page<HabitacionEntity> habitaciones = habitacionService.findAll(pagReq);
        RenderPagina<HabitacionEntity> pageRender = new RenderPagina<>("lista-habitacion", habitaciones);
        model.addAttribute("habitaciones", habitaciones);
        model.addAttribute("page", pageRender);
        model.addAttribute("operacion", "Lista Habitacion");
        return "habitacion/lista-habitacion";
    }

    @InitBinder("habitacionEntity")
    public void evaluar(WebDataBinder binder){
        //webDataBinder.addValidators(clienteValidacion);
        binder.registerCustomEditor(String.class, "nombre", new MayusculasConverter());
    }

    @GetMapping("borrar-habitacion/{id}")
    public String borrarHabitacion(@PathVariable("id") Integer id,Model model,
                                RedirectAttributes flash){
        habitacionService.borrar(id);
        flash.addFlashAttribute("success","Habitacion se borro bien");
        return "redirect:/habitacion/lista-habitacion";
    }

    @GetMapping("modificar-habitacion/{id}")
    public String modificarHabitacion(@PathVariable("id") Integer id,Model model){
        HabitacionEntity habitacion= habitacionService.buscarHabitacionId(id);
        model.addAttribute("habitacionEntity",habitacion);
        return "habitacion/alta-habitacion";
    }
}
