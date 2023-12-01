package dgtic.core.controller.cliente;

import dgtic.core.converter.MayusculasConverter;
import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.service.cliente.ClienteService;
import dgtic.core.util.RenderPagina;
import dgtic.core.validation.ClienteValidacion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.fileupload.RequestContext;
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
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Map;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteValidacion clienteValidacion;
    @Autowired
    ClienteService clienteService;

    @GetMapping("alta-cliente")
    public String paginaAlta(Model model){
        ClienteEntity clienteEntity=new ClienteEntity();
        model.addAttribute("operacion","Alta Cliente");
        model.addAttribute("clienteEntity",clienteEntity);
        return "cliente/alta-cliente";
    }
    @PostMapping("alta-cliente")
    public String almacenarCliente(@RequestParam("nombre")String nombre,
                                   @RequestParam("apellidoPaterno")String apellido,
                                   Model model){
        ClienteEntity cliente=new ClienteEntity();
        cliente.setNombre(nombre);
        cliente.setApellidoPaterno(apellido);
        cliente.setTarjetaCredito("324242");
        cliente.setCorreo("f@demo3.com");
        cliente.setTelefono("23424231");
        try {
            clienteService.guardar(cliente);
        }catch(Exception ex){
            model.addAttribute("warning","Correo o teléfono repetido");
            return "cliente/alta-cliente";
        }

        model.addAttribute("success","Se almaceno con éxito");

        return "cliente/alta-cliente";
    }
    @PostMapping("entrada-uno")
    public String entradaUno(@Valid @ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
                             BindingResult result, Model model,
                             RedirectAttributes flash){
        //clienteValidacion.validate(clienteEntity,result);
        if(result.hasErrors()){
            model.addAttribute("operacion","Error en los datos");
            return "cliente/alta-cliente";
        }
        try {
            clienteService.guardar(clienteEntity);
            flash.addFlashAttribute("success","Se almaceno con éxito");
            //flash.addFlashAttribute("objeto",clienteEntity);
            return "redirect:/cliente/lista-cliente";
        }catch(Exception ex){
            ObjectError er=new ObjectError("Duplicados","Teléfono o correo ya existe");
            model.addAttribute("warning","Correo o teléfono repetido");
            result.addError(er);
        }
        return "cliente/alta-cliente";
    }
    @InitBinder("clienteEntity")
    public void evaluar(WebDataBinder binder){
        //binder.addValidators(clienteValidacion);
        binder.registerCustomEditor(String.class,
                "nombre",new MayusculasConverter());

    }
//    @GetMapping("lista-cliente")
//    public String paginaLista(Model model, HttpServletRequest request){
//        Map<String,?> input= RequestContextUtils.getInputFlashMap(request);
//        ClienteEntity c=(ClienteEntity) input.get("objeto");
//        System.out.println(c.toString());
//        model.addAttribute("operacion","Lista Cliente");
//        return "cliente/lista-cliente";
//    }
    @GetMapping("lista-cliente")
    public String paginaLista(@RequestParam(name="page",defaultValue = "0") int page,
                                  Model model){
        Pageable pagReq= PageRequest.of(page,2);
        Page<ClienteEntity> cliente=clienteService.findAll(pagReq);
        RenderPagina<ClienteEntity> render=new RenderPagina<>("lista-cliente",cliente);
        model.addAttribute("page",render);
        model.addAttribute("cliente",cliente);
        model.addAttribute("operacion","Lista Cliente");
        return "cliente/lista-cliente";
    }
    @GetMapping("borrar-cliente/{id}")
    public String borrarCliente(@PathVariable("id") Integer id,Model model,
                                RedirectAttributes flash){
        clienteService.borrar(id);
        flash.addFlashAttribute("success","Cliente se borro bien");
        return "redirect:/cliente/lista-cliente";
    }
    @GetMapping("modificar-cliente/{id}")
    public String modificarCliente(@PathVariable("id") Integer id,Model model){
        ClienteEntity cliente=clienteService.buscarClienteId(id);
        model.addAttribute("clienteEntity",cliente);
        return "cliente/alta-cliente";
    }
}
