package dgtic.core.controller.habitacion;

import dgtic.core.converter.FloatConvertir;
import dgtic.core.converter.MayusculasConverter;
import dgtic.core.model.entity.HabitacionEntity;
import dgtic.core.model.entity.HotelEntity;
import dgtic.core.service.habitacion.HabitacionService;
import dgtic.core.service.hotel.HotelService;
import dgtic.core.util.Archivos;
import dgtic.core.util.RenderPagina;
import dgtic.core.validation.HabitacionValidacion;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;

@Controller
@RequestMapping(value = "habitacion")
@SessionAttributes("habitacion")
public class HabitacionController {
    @Autowired
    HotelService hotelService;

    @Autowired
    HabitacionService habitacionService;

    @Autowired
    private HabitacionValidacion habitacionValidacion;

    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @GetMapping("alta-habitacion")
    public String altaHabitacion(Model model) {
        HabitacionEntity habitacionEntity=new HabitacionEntity();
        model.addAttribute("contenido", "Alta Habitación");
        //llenar el select de hoteles
        List<HotelEntity> select=hotelService.buscarHotel();
        model.addAttribute("selectHotel",select);

        model.addAttribute("habitacion",habitacionEntity);
        return "habitacion/alta-habitacion";
    }

    @PostMapping("alta-habitacion")
    public String altaHabitacion(@Valid @ModelAttribute("habitacion") HabitacionEntity habitacion
            , BindingResult result,
                                 Model model, RedirectAttributes flash,
                                 SessionStatus status, HttpSession sesion) {
        //llenar el select de hoteles
        List<HotelEntity> select=hotelService.buscarHotel();
        if (result.hasErrors()) {
            for (FieldError e :result.getFieldErrors()) {
                System.out.println(e.getDefaultMessage());
                System.out.println(e.getCode());
            }


            model.addAttribute("selectHotel",select);
            model.addAttribute("operacion", "Error en datos");
            return "habitacion/alta-habitacion";
        }
        //salvando
        System.out.println(habitacion.toString());
        if(habitacion.getImagen()!=null || !habitacion.getImagen().isEmpty()){
            String archivo=habitacion.getImagen();
            String nuevoArchivo=habitacion.getNombre()+"_"+archivo;
            Archivos.renombrar(archivoRuta,archivo,nuevoArchivo);
            habitacion.setImagen(nuevoArchivo);
        }
        habitacionService.guardar(habitacion);
        flash.addFlashAttribute("success","Habitación se almaceno con éxito");
        return "redirect:/habitacion/lista-habitacion";

    }

    @GetMapping("lista-habitacion")
    public String listaHabitacion(@RequestParam(name = "page", defaultValue = "0") int page,
                                  Model model){
        Pageable pagReq = PageRequest.of(page, 2);
        Page<HabitacionEntity> habitaciones = habitacionService.findAll(pagReq);
        RenderPagina<HabitacionEntity> render = new RenderPagina<>("lista-habitacion",habitaciones);
        model.addAttribute("habitaciones", habitaciones);
        model.addAttribute("page", render);
        model.addAttribute("operacion", "Lista de las Habitaciones");
        return "habitacion/lista-habitacion";
    }
    @GetMapping("borrar-habitacion/{id}")
    public String borrarCliente(@PathVariable("id") Integer id,Model model,
                                RedirectAttributes flash){
        System.out.println(id);
        habitacionService.borrar(id);
        flash.addFlashAttribute("success","habitación se borro con éxito");
        return "redirect:/habitacion/lista-habitacion";
    }
    @GetMapping("modificar-habitacion/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        HabitacionEntity habitacion = habitacionService.buscarHabitacionlId(id);
        model.addAttribute("habitacion", habitacion);
        //llenar el select de hoteles
        List<HotelEntity> select=hotelService.buscarHotel();
        model.addAttribute("selectHotel",select);
        return "habitacion/alta-habitacion";
    }

    @InitBinder("habitacion")
    public void registroNumero(WebDataBinder binder){
        //binder.registerCustomEditor(float.class,new FloatConvertir(Float.class));
        binder.setValidator(habitacionValidacion);
    }

    @PostMapping(value = "salvar")
    public String guardar(@RequestParam("imagenarchivo") MultipartFile multipartFile,
                          Model model,
                          HttpSession session){
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                HabitacionEntity habitacion=(HabitacionEntity) session.getAttribute("habitacion");
                habitacion.setImagen(imagenNombre);
            }
        }
        List<HotelEntity> select=hotelService.buscarHotel();
        model.addAttribute("selectHotel",select);

        return "habitacion/alta-habitacion";
    }

}
