package dgtic.core.controller.cuenta;

import dgtic.core.model.entity.CuentaEntity;
import dgtic.core.model.entity.EstatusCuentaEntity;
import dgtic.core.model.entity.PrestamoEntity;
import dgtic.core.model.entity.UsuarioEntity;
import dgtic.core.service.cuenta.CuentaService;
import dgtic.core.service.estatus.EstatusCuentaService;
import dgtic.core.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("cuenta")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private EstatusCuentaService estatusCuentaService;

    @GetMapping("lista-cuentas")
    public String paginaLista(@RequestParam(name="page",defaultValue = "0") int page,
                              Model model){
        Pageable pageable= PageRequest.of(page,10);
        Page<CuentaEntity> cuentas = cuentaService.findAll(pageable);
        RenderPagina<CuentaEntity> renderPagina=new RenderPagina<CuentaEntity>("lista-cuentas",cuentas);
        model.addAttribute("page",renderPagina);
        model.addAttribute("cuentas",cuentas);
        model.addAttribute("operacion","Lista de Cuentas");
        return "cuenta/lista-cuentas";
    }

    @GetMapping("modificar-cuenta/{id}")
    public String modificarCliente(@PathVariable("id") Integer id, Model model){
        List<EstatusCuentaEntity> selectEstatusCuenta=estatusCuentaService.buscarEstatusCuentas();
        model.addAttribute("selectEstatusCuenta",selectEstatusCuenta);
        CuentaEntity cuentaEntity =cuentaService.buscarCuentaId(id);
        model.addAttribute("cuentaEntity",cuentaEntity);
        return "cuenta/modificar-cuenta";
    }

    @PostMapping("actualizar-cuenta")
    public String registrarPrestamo(@ModelAttribute("cuentaEntity") CuentaEntity cuentaEntity,
                                    Model model,
                                    RedirectAttributes flash){
            try {
                cuentaEntity.setFechaApertura(new Date());
                cuentaService.guardar(cuentaEntity);
                flash.addFlashAttribute("success","Se almaceno con éxito");
            }
            catch(Exception ex){
                model.addAttribute("warning","Error al guardar");
                return "cuenta/modificar-cuenta";
            }
            return "redirect:/cuenta/lista-cuentas";
        }
    }
