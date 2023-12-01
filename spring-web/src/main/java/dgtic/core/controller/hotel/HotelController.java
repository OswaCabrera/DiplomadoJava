package dgtic.core.controller.hotel;

import dgtic.core.model.entity.HotelEntity;
import dgtic.core.service.hotel.HotelService;
import dgtic.core.util.Archivos;
import dgtic.core.util.RenderPagina;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "hotel")
@SessionAttributes("hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;


    @GetMapping("alta-hotel")
    public String altaHotel(Model model){
        HotelEntity hotelEntity=new HotelEntity();
        model.addAttribute("operacion", "Alta Hotel");
        model.addAttribute("hotel", hotelEntity);
        return "hotel/alta-hotel";
    }
    @PostMapping("entrada-hotel")
    public String salvarObjectThymeleaf(@Valid @ModelAttribute("hotel") HotelEntity hotel, BindingResult result,
                                        Model model, RedirectAttributes flash,
                                        SessionStatus status, HttpSession sesion) {
        if (result.hasErrors()) {
            model.addAttribute("operacion", "Error en datos");
            return "hotel/alta-hotel";
        }
        try{

            if(hotel.getImagen()!=null || !hotel.getImagen().isEmpty()){
                String archivo=hotel.getImagen();
                String nuevoArchivo=hotel.getCorreo()+"_"+archivo;
                Archivos.renombrar(archivoRuta,archivo,nuevoArchivo);
                hotel.setImagen(nuevoArchivo);
            }
            hotelService.guardar(hotel);
            status.setComplete();
            flash.addFlashAttribute("success","Hotel se almaceno con éxito");
            return "redirect:/hotel/lista-hotel";
        }catch(DataIntegrityViolationException exception){
            ObjectError er = new ObjectError("duplicados", "Ya esta registrado la tarjeta o correo o teléfono");
            result.addError(er);
            model.addAttribute("success", "Ya esta registrado la tarjeta o correo o teléfono");
        }
        System.out.println(hotel);
        model.addAttribute("hotel", hotel);
        return "hotel/alta-hotel";
    }
    @GetMapping("lista-hotel")
    public String listaClientes(@RequestParam(name = "page", defaultValue = "0") int page,
                                Model model) {
        Pageable pagReq = PageRequest.of(page, 2);
        Page<HotelEntity> hotel = hotelService.findAll(pagReq);
        RenderPagina<HotelEntity> render = new RenderPagina<>("lista-hotel", hotel);
        model.addAttribute("hotel", hotel);
        model.addAttribute("page", render);
        model.addAttribute("operacion", "Lista de los Hoteles");
        return "hotel/lista-hotel";
    }
    @GetMapping("modificar-hotel/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        HotelEntity hotel = hotelService.buscarHotelId(id);
        model.addAttribute("hotel", hotel);
        return "hotel/alta-hotel";
    }
    @GetMapping("borrar-hotel/{id}")
    public String borrarCliente(@PathVariable("id") Integer id,Model model,
                                RedirectAttributes flash){
        hotelService.borrar(id);
        flash.addFlashAttribute("success","Hotel se borro con éxito");
        return "redirect:/hotel/lista-hotel";
    }
    @PostMapping(value = "salvar")
    public String guardar(@RequestParam("imagenarchivo") MultipartFile multipartFile,
                          HttpSession session){
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                HotelEntity hotel=(HotelEntity) session.getAttribute("hotel");
                hotel.setImagen(imagenNombre);
            }
        }

        return "hotel/alta-hotel";
    }

}
