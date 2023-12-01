package dgtic.core.controller.prestamo;

import dgtic.core.model.entity.PrestamoEntity;
import dgtic.core.model.entity.UsuarioEntity;
import dgtic.core.service.prestamo.PrestamoService;
import dgtic.core.service.usuario.UsuarioService;
import dgtic.core.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("prestamo")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("alta-prestamo")
    public String paginaAlta(Model model){
        PrestamoEntity prestamoEntity = new PrestamoEntity();
        List<UsuarioEntity> selectUsuario =usuarioService.buscarUsuario();
        model.addAttribute("selectUsuario",selectUsuario);
        System.out.println(selectUsuario);
        model.addAttribute("operacion","Alta Prestamo");
        model.addAttribute("prestamoEntity", prestamoEntity);
        return "prestamo/alta-prestamo";
    }

    @PostMapping("registrar-prestamo")
    public String registrarPrestamo(@Valid @ModelAttribute("prestamoEntity") PrestamoEntity prestamoEntity,
                                    BindingResult result,
                                    Model model,
                                    RedirectAttributes flash){
        if(result.hasErrors()){
            model.addAttribute("operacion","Error en los datos");
            List<UsuarioEntity> selectUsuario =usuarioService.buscarUsuario();
            model.addAttribute("selectUsuario",selectUsuario);
            return "prestamo/alta-prestamo";
        }
        try {
            prestamoService.guardar(prestamoEntity);
            flash.addFlashAttribute("success","Se almaceno con éxito");
        }catch(Exception ex){
            model.addAttribute("warning","Error al guardar");
            return "prestamo/alta-prestamo";
        }
        return "redirect:/prestamo/lista-prestamos";
    }

    @GetMapping("lista-prestamos")
    public String listaPrestamo(@RequestParam(name="page",defaultValue = "0") int page,
                                Model model){
        Pageable pageable= PageRequest.of(page,5);
        Page<PrestamoEntity> prestamos = prestamoService.findAll(pageable);
        RenderPagina<PrestamoEntity> renderPagina=new RenderPagina<PrestamoEntity>("lista-prestamos",prestamos);
        model.addAttribute("page",renderPagina);
        model.addAttribute("prestamos",prestamos);
        model.addAttribute("operacion","Lista de Prestamos");
        return "prestamo/lista-prestamos";
    }

    @GetMapping("borrar-prestamo/{id}")
    public String borrarPrestamo(@PathVariable("id") Integer id, Model model,
                                RedirectAttributes flash){
        prestamoService.borrar(id);
        flash.addFlashAttribute("success","El prestamo se borró bien");
        return "redirect:/prestamo/lista-prestamos";
    }

    @GetMapping("modificar-prestamo/{id}")
    public String modificarCliente(@PathVariable("id") Integer id,Model model){
        PrestamoEntity prestamo = prestamoService.buscarPrestamoId(id);
        model.addAttribute("prestamoEntity",prestamo);
        List<UsuarioEntity> selectUsuario =usuarioService.buscarUsuario();
        model.addAttribute("selectUsuario",selectUsuario);
        return "prestamo/alta-prestamo";
    }

}
