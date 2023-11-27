package dgtic.core.controller.usuario;

import dgtic.core.model.entity.CuentaEntity;
import dgtic.core.model.entity.UsuarioEntity;
import dgtic.core.repository.CuentaRepository;
import dgtic.core.service.cuenta.CuentaService;
import dgtic.core.service.estatus.EstatusCuentaService;
import dgtic.core.service.usuario.UsuarioService;
import dgtic.core.util.RenderPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private EstatusCuentaService estatusCuentaService;

    @GetMapping("alta-usuario")
    public String paginaAlta(Model model){
        UsuarioEntity usuarioEntity=new UsuarioEntity();
        model.addAttribute("operacion","Alta Usuario");
        model.addAttribute("usuarioEntity",usuarioEntity);
        return "usuario/alta-usuario";
    }

    @PostMapping("alta-usuario")
    public String registrarUsuario(@ModelAttribute("usuarioEntity") UsuarioEntity usuarioEntity,
                                   BindingResult result, Model model,
                                   RedirectAttributes flash){
        if(result.hasErrors()){
            model.addAttribute("operacion","Error en los datos");
            System.out.println("Error en los datos");
            return "usuario/alta-usuario";
        }
        try {
            if(usuarioEntity.getRol_id()==null)
                usuarioEntity.setRol_id(2);
            usuarioService.guardar(usuarioEntity);
            System.out.println("Usuario guardado");
            if (cuentaService.buscarCuentaUsuarioId(usuarioEntity.getId_usuario())==null)
            {
                CuentaEntity cuentaNueva=new CuentaEntity();
                cuentaNueva.setUsuario(usuarioEntity);
                cuentaNueva.setFechaApertura(new Date());
                cuentaNueva.setSaldo(0);
                cuentaNueva.setEstatus(estatusCuentaService.buscarEstatusCuentaId(3));
                cuentaService.guardar(cuentaNueva);
                System.out.println("Cuenta guardada");
            }
            flash.addFlashAttribute("success","Se almaceno con éxito");
            return "redirect:/usuario/lista-usuarios";
        }catch(Exception ex){
            ObjectError er=new ObjectError("Duplicados","Teléfono o correo ya existe");
            model.addAttribute("warning","Correo o teléfono repetido");
            result.addError(er);
        }
        return "usuario/alta-usuario";
    }

    @GetMapping("lista-usuarios")
    public String paginaLista(@RequestParam(name="page",defaultValue = "0") int page,
                              Model model){
        Pageable pageable= PageRequest.of(page,10);
        Page<UsuarioEntity> usuarios = usuarioService.findAll(pageable);
        RenderPagina<UsuarioEntity> renderPagina=new RenderPagina<UsuarioEntity>("lista-usuarios",usuarios);
        model.addAttribute("page",renderPagina);
        model.addAttribute("usuarios",usuarios);
        model.addAttribute("operacion","Lista de Usuarios");
        return "usuario/lista-usuarios";
    }

    @GetMapping("borrar-usuario/{id}")
    public String borrarCliente(@PathVariable("id") Integer id,Model model,
                                RedirectAttributes flash){
        usuarioService.borrar(id);
        flash.addFlashAttribute("success","Usuario se borro bien");
        return "redirect:/usuario/lista-usuarios";
    }

    @GetMapping("modificar-usuario/{id}")
    public String modificarCliente(@PathVariable("id") Integer id,Model model){
        UsuarioEntity usuario=usuarioService.buscarUsuarioId(id);
        model.addAttribute("usuarioEntity",usuario);
        return "usuario/alta-usuario";
    }

}
